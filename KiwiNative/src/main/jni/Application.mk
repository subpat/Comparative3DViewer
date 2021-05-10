APP_OPTIM := release
APP_PLATFORM := android-21
APP_STL := c++_static
#APP_CFLAGS
APP_CPPFLAGS += -frtti
APP_CPPFLAGS += -fexceptions
APP_CPPFLAGS += -DANDROID
#Unsupported abis for VTK v8.2.0 rc2 := arm64-v8a mips64
APP_ABI := arm64-v8a armeabi armeabi-v7a mips mips64 x86 x86_64
#APP_ABI := arm64-v8a armeabi-v7a x86 x86_64
LOCAL_ARM_NEON := true
#APP_MODULES := KiwiNative
#NDK_TOOLCHAIN_VERSION := clang
NDK_TOOLCHAIN_VERSION := 4.9
