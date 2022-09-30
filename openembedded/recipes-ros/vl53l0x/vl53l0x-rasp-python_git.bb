# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://github.com/johnbryanmoore/VL53L0X_rasp_python.git;protocol=https \
	  file://0001.patch "

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.


do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# You will almost certainly need to add additional arguments here
	oe_runmake
}

inherit python-dir

do_install () {
	# NOTE: unable to determine what to put here - there is a Makefile but no
	# target named "install", so you will need to define this yourself
	install -d ${D}${libdir}
	install -m 0755 ${S}/bin/vl53l0x_python.so ${D}${libdir}
	install -d ${D}${PYTHON_SITEPACKAGES_DIR}
	install -m 0755 ${S}/python/VL53L0X.py ${D}${PYTHON_SITEPACKAGES_DIR}
#	:
}

INSANE_SKIP_${PN} = "ldflags"

FILES_${PN} = " /usr/lib/vl53l0x_python.so  \
		${PYTHON_SITEPACKAGES_DIR}/VL53L0X.py "

DEPENDS += "python python-smbus"
RRECOMMENDS_${PN} += "python python-smbus"
RDEPENDS_${PN} += "python python-smbus"
