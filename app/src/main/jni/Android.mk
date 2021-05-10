LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := libKiwiNative
LOCAL_SRC_FILES := ../jniLibs/$(TARGET_ARCH_ABI)/libKiwiNativeVtk.so

include $(PREBUILT_SHARED_LIBRARY)
