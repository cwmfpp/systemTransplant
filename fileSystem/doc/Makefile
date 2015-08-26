all:
	@echo "start..."
	mkdir -p lib usr/lib etc/init.d
	cp -a /usr/local/arm/4.3.2/arm-none-linux-gnueabi/libc/armv4t/lib/l*.so* ./lib
	cp -a /usr/local/arm/4.3.2/arm-none-linux-gnueabi/libc/armv4t/usr/lib/*.so* ./usr/lib
	mkdir -p dev proc sys tmp var root home/cwm mnt
	touch etc/inittab etc/init.d/rcS
	chmod +x etc/init.d/rcS
	echo "::sysinit:/etc/init.d/rcS\n::askfirst:/bin/sh\n::ctrlaltdel:/sbin/reboot\n::shutdown:/sbin/swapoff -a\n::shutdown:/bin/umount -a -r\n::restart:/sbin/init" > etc/inittab
	echo "mount -t proc proc /proc\nmount -t sysfs sysfs /sys\necho /sbin/mdev > /proc/sys/kernel/hotplug\nmdev -s" > etc/init.d/rcS
	`sudo mknod dev/console c 5 1`
	`sudo mknod dev/null c 1 3`
	arm-linux-strip -g -s ./lib/* ./usr/lib/* 

clean:
	rm dev home mnt proc sys usr/lib etc lib root tmp var -rf

.PHONY:clean
