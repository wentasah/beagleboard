#!/usr/bin/env novaboot
load build/linux/arch/arm/boot/uImage-dtb.am335x-boneblack console=tty0 console=ttyO0,115200n8 ro rootfstype=ext4 rootwait fixrtc init=/lib/systemd/systemd root=/dev/mmcblk0p2
# root=/dev/mmcblk0p2
# root=UUID=316d0f1a-3c95-4772-a7e0-66d2a7148024

load build/linux/arch/arm/boot/dts/am335x-boneblack.dtb
