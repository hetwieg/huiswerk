# Vars
FILE=dictaat
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
GIT=git

# make default == all
# __COMPLETELY__ builds the pdf for the documentation. Remove's all the temp crap
# Also makes sure that interlinked glossaries work as well. 
all:

	$(MKDIR) $(TMP)
	${CP} ${FILE}${EXT} ${TMP}${FILE}${EXT}
	${MKDIR} ${TMP}/${IMG}
	${CP} ${IMG} ${TMP} -r
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
	${PDFLATEX} ${FILE}
	${CP} ${TMP}${FILE}${PDF} ${BASE}${FILE}${PDF}
# Clean temp dir
	${RM} ${TMP}

save:
	${GIT} add .
	${GIT} commit --allow-empty
	${GIT} push
