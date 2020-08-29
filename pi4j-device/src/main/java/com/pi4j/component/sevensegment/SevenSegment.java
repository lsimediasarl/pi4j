/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi4j.component.sevensegment;

import com.pi4j.io.gpio.GpioController;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: Device Abstractions
 * FILENAME      :  SevenSegment.java
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
 *
 */
/**
 * Base of seven segment implementation
 *
 *
 * @author sbodmer
 */
public abstract class SevenSegment {
    protected GpioController gpio = null;

    public SevenSegment(GpioController gpio) {
        this.gpio = gpio;
    }

    /**
     * Show the digits (x first char of the string)
     *
     * @param digits
     */
    public abstract void show(String digits);

    /**
     * Show the passed digits at the specified index
     *
     * @param digits
     * @param index
     */
    public abstract void showDigit(String digits, int index);

    /**
     * Return the anctual displayed digits
     * @return
     */
    public abstract String displayed();

    /**
     * Clear the display
     *
     */
    public abstract void clear();


}
