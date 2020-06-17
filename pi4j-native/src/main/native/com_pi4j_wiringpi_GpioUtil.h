/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: JNI Native Library
 * FILENAME      :  com_pi4j_wiringpi_GpioUtil.h
 * 
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://www.pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2020 Pi4J
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */
/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_pi4j_wiringpi_GpioUtil */

#ifndef _Included_com_pi4j_wiringpi_GpioUtil
#define _Included_com_pi4j_wiringpi_GpioUtil
#ifdef __cplusplus
extern "C" {
#endif
#undef com_pi4j_wiringpi_GpioUtil_DIRECTION_IN
#define com_pi4j_wiringpi_GpioUtil_DIRECTION_IN 0L
#undef com_pi4j_wiringpi_GpioUtil_DIRECTION_OUT
#define com_pi4j_wiringpi_GpioUtil_DIRECTION_OUT 1L
#undef com_pi4j_wiringpi_GpioUtil_DIRECTION_HIGH
#define com_pi4j_wiringpi_GpioUtil_DIRECTION_HIGH 2L
#undef com_pi4j_wiringpi_GpioUtil_DIRECTION_LOW
#define com_pi4j_wiringpi_GpioUtil_DIRECTION_LOW 3L
#undef com_pi4j_wiringpi_GpioUtil_EDGE_NONE
#define com_pi4j_wiringpi_GpioUtil_EDGE_NONE 0L
#undef com_pi4j_wiringpi_GpioUtil_EDGE_BOTH
#define com_pi4j_wiringpi_GpioUtil_EDGE_BOTH 1L
#undef com_pi4j_wiringpi_GpioUtil_EDGE_RISING
#define com_pi4j_wiringpi_GpioUtil_EDGE_RISING 2L
#undef com_pi4j_wiringpi_GpioUtil_EDGE_FALLING
#define com_pi4j_wiringpi_GpioUtil_EDGE_FALLING 3L
/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    export
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_pi4j_wiringpi_GpioUtil_export
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    unexport
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_pi4j_wiringpi_GpioUtil_unexport
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    isExported
 * Signature: (I)Z
 */
JNIEXPORT jboolean JNICALL Java_com_pi4j_wiringpi_GpioUtil_isExported
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    setEdgeDetection
 * Signature: (II)Z
 */
JNIEXPORT jboolean JNICALL Java_com_pi4j_wiringpi_GpioUtil_setEdgeDetection
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    getEdgeDetection
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_wiringpi_GpioUtil_getEdgeDetection
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    setDirection
 * Signature: (II)Z
 */
JNIEXPORT jboolean JNICALL Java_com_pi4j_wiringpi_GpioUtil_setDirection
  (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    getDirection
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_wiringpi_GpioUtil_getDirection
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    isPinSupported
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_wiringpi_GpioUtil_isPinSupported
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    isPrivilegedAccessRequired
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_com_pi4j_wiringpi_GpioUtil_isPrivilegedAccessRequired
  (JNIEnv *, jclass);

/*
 * Class:     com_pi4j_wiringpi_GpioUtil
 * Method:    enableNonPrivilegedAccess
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_pi4j_wiringpi_GpioUtil_enableNonPrivilegedAccess
  (JNIEnv *, jclass);

#ifdef __cplusplus
}
#endif
#endif
