/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: JNI Native Library
 * FILENAME      :  com_pi4j_jni_SerialInterrupt.h
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
/* Header for class com_pi4j_jni_SerialInterrupt */

#ifndef _Included_com_pi4j_jni_SerialInterrupt
#define _Included_com_pi4j_jni_SerialInterrupt
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_pi4j_jni_SerialInterrupt
 * Method:    enableSerialDataReceiveCallback
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_jni_SerialInterrupt_enableSerialDataReceiveCallback
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_pi4j_jni_SerialInterrupt
 * Method:    disableSerialDataReceiveCallback
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_pi4j_jni_SerialInterrupt_disableSerialDataReceiveCallback
  (JNIEnv *, jclass, jint);


/*
 * Class:     com_pi4j_jni_SerialInterrupt
 * Method:    SerialInterrupt_JNI_OnLoad
 */
jint SerialInterrupt_JNI_OnLoad(JavaVM *jvm);

/*
 * Class:     com_pi4j_jni_SerialInterrupt
 * Method:    SerialInterrupt_JNI_OnUnload
 */
void SerialInterrupt_JNI_OnUnload(JavaVM *jvm);

#ifdef __cplusplus
}
#endif
#endif
