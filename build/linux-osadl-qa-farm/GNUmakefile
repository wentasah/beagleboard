export ARCH=arm
export CROSS_COMPILE=/opt/OSELAS.Toolchain-2014.12.1/arm-cortexa8-linux-gnueabihf/gcc-4.9.2-glibc-2.20-binutils-2.24-kernel-3.16-sanitized/bin/arm-cortexa8-linux-gnueabihf-
export LOADADDR=80008000

VERSION = 3
PATCHLEVEL = 8

lastword = $(word $(words $(1)),$(1))
makedir := $(dir $(call lastword,$(MAKEFILE_LIST)))

ifeq ("$(origin V)", "command line")
VERBOSE := $(V)
endif
ifneq ($(VERBOSE),1)
Q := @
endif

MAKEARGS := -C ../../linux-osadl-qa-farm
MAKEARGS += O=$(if $(patsubst /%,,$(makedir)),$(CURDIR)/)$(patsubst %/,%,$(makedir))

MAKEFLAGS += --no-print-directory

.PHONY: all $(MAKECMDGOALS)

all	:= $(filter-out all Makefile,$(MAKECMDGOALS))

ifeq ($(all),)
all:
	$(Q)$(MAKE) $(MAKEARGS) uImage dtbs
# 	$(Q)$(MAKE) $(MAKEARGS) uImage-dtb.am335x-boneblack
else
all:
	$(Q)$(MAKE) $(MAKEARGS) $(all)
endif

all: ../../linux-osadl-qa-farm/firmware/am335x-pm-firmware.bin

../../linux-osadl-qa-farm/firmware/am335x-pm-firmware.bin: ../../linux/firmware/am335x-pm-firmware.bin
	ln -sr $(realpath $^) $@

Makefile:;

$(all): all
	@:

%/: all
	@:
