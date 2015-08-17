ifeq ($(CONFIG_PM_H1940),y)
	zreladdr-y	+= 0x10108000
	params_phys-y	:= 0x10100100
else
	zreladdr-y	+= 0x50008000
	params_phys-y	:= 0x50000100
endif
