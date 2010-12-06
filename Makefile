#: AAN TE PASSEN NAAR JUISTE PROJECT!
PROJECT=datastructuren

# Vars
FILE=dictaat
SKEL=skel/
EXT=.tex
IMG=images/
TMP=tmp/
BASE=./
PDF=.pdf


# Binaries
LATEX=/usr/bin/latex -output-directory=${TMP}
PDFLATEX=/usr/bin/pdflatex -halt-on-error -output-directory ${TMP}
MKGLOS=/usr/bin/makeglossaries
XINDY=xindy -L english   -I xindy -M "${FILE}" -t "${FILE}.glg" -o "${FILE}.gls" "${FILE}.glo"
MKDIR=mkdir -p
MKINDEX=texindy -L english ${FILE}.idx
RM=rm -rf
CP=cp
CD=cd
TOUCH=touch
GIT=git

# make default == all
# __COMPLETELY__ builds the pdf for the documentation. Remove's all the temp crap
# Also makes sure that interlinked glossaries work as well. 
all:

	$(MKDIR) $(TMP)
	${CP} ${SKEL}${FILE}${EXT} ${TMP}${FILE}${EXT}
	${CP} ${PROJECT}/*${EXT} ${TMP}
	${MKDIR} ${TMP}/${IMG}
	${TOUCH} ${TMP}${FILE}.glo #Make sure these 2 exists, else xindy will error out
	${TOUCH} ${TMP}${FILE}.xdy


# First run, init
	${LATEX} ${TMP}${FILE}${EXT}
# Glossary:
#	${CD} ${TMP}; $(MKGLOS) ${FILE}
# Xindy:
	${CD} ${TMP}; ${XINDY}
# Index, with texindy:
	${CD} ${TMP}; ${MKINDEX}	
# Interlinking check
	${LATEX} ${TMP}${FILE}${EXT}
#	${CD} ${TMP}; $(MKGLOS) ${FILE}
	${CD} ${TMP}; ${XINDY}
# Final compile:
	${PDFLATEX} ${FILE}${EXT}
	${CP} ${TMP}${FILE}${PDF} ${BASE}${PROJECT}${PDF}
# Clean temp dir
	${RM} ${TMP}

save:
	${GIT} add .
	${GIT} commit --allow-empty
	${GIT} push origin master

update:
	${GIT} pull origin master

clean:
	${RM} ${TMP} -rf
