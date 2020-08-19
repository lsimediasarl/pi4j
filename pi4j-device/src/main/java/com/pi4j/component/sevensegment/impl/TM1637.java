/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi4j.component.sevensegment.impl;

import com.pi4j.component.sevensegment.SevenSegment;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalMultipurpose;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.Gpio;
import java.util.HashMap;
import javafx.scene.input.KeyCode;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: Device Abstractions
 * FILENAME      :  TM1637.java
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
 * TM1637 based 7 segment display (4 digit)
 *
 * https://wiki.seeedstudio.com/Grove-4-Digit_Display/
 *
 * http://www.pibits.net/code/tm1637-7-segment-display-example-on-a-raspberry-pi.php
 *
 * https://pypi.org/project/raspberrypi-tm1637/
 *
 * <PRE>
 * 2 pin are needed for data (digital in/out, clock out)
 * 1 pin for power (5 volt)
 * 1 pin for ground
 *
 * Red = 5v
 * Black = Ground
 * White = Digital in/out
 * Yellow = Clock
 * </PRE>
 *
 * The colon is display at the index 1 (digit 2)
 *
 * 7 bit, one foe each segment
 *
 * <PRE>
 *    A
 *   ---
 * F | | B *
 *   -G-   H (on 2nd segment)
 * E | | C *
 *   ---
 *    D
 *
 *   HGFEDCBA
 * 0b01101101 = 0x6D = 109 = show "5"
 * </PRE>
 *
 * @author sbodmer
 */
public class TM1637 extends SevenSegment {

    static HashMap<String, Integer> charmap = new HashMap<>();

    static {
        charmap.put("0", 0x3f); // 63
        charmap.put("1", 0x06); // 6
        charmap.put("2", 0x5b); // 91
        charmap.put("3", 0x4f); // 79
        charmap.put("4", 0x66); // 102
        charmap.put("5", 0x6d); // 109
        charmap.put("6", 0x7d); // 125
        charmap.put("7", 0x07); // 7
        charmap.put("8", 0x7f); // 127
        charmap.put("9", 0x6f); // 111
        charmap.put("A", 0x77); // 119
        charmap.put("a", 0x77);
        charmap.put("b", 0x7c); // 124
        charmap.put("B", 0x7f); // 127
        charmap.put("C", 0x39); // 57
        charmap.put("c", 0x58); //
        charmap.put("D", 0x3f); // 63
        charmap.put("d", 0x5e); // 94
        charmap.put("E", 0x79); // 121
        charmap.put("e", 0x79);
        charmap.put("F", 0x71); // 113
        charmap.put("f", 0x71);
        charmap.put("G", 0x3d); // 61
        charmap.put("g", 0x3d);
        charmap.put("H", 0x76); // 118
        charmap.put("h", 0x74); //
        charmap.put("I", 0x06); // 6
        charmap.put("i", 0x06);
        charmap.put("J", 0x1E); // 30
        charmap.put("j", 0x1E);
        charmap.put("K", 0x76); // 118
        charmap.put("k", 0x76);
        charmap.put("L", 0x38); // 56
        charmap.put("l", 0x06); //
        charmap.put("M", 0x54);
        charmap.put("m", 0x54);
        charmap.put("N", 0x54);
        charmap.put("n", 0x54); // 84
        charmap.put("O", 0x3f); // 63
        charmap.put("o", 0x5c); //
        charmap.put("P", 0x73); // 115
        charmap.put("p", 0x73);
        charmap.put("Q", 0x3f);
        charmap.put("q", 0x3f);
        charmap.put("r", 0x50); // 80
        charmap.put("R", 0x50);
        charmap.put("s", 0x6d);
        charmap.put("S", 0x6d); // 109
        charmap.put("T", 0x31); // 49
        charmap.put("t", 0x31);
        charmap.put("U", 0x3e); // 62
        charmap.put("u", 0x3e);
        charmap.put("V", 0x3e); //
        charmap.put("v", 0x1c); // 28
        charmap.put("W", 0x2a); // 42
        charmap.put("w", 0x2a);
        charmap.put("X", 0x76); // 118
        charmap.put("x", 0x76); // 118
        charmap.put("Y", 0x66);
        charmap.put("y", 0x6e); // 110
        charmap.put("Z", 0x5b); // 91
        charmap.put("z", 0x5b); // 91
        charmap.put("-", 0x40); // 64
        charmap.put("_", 0x08); // 8
        charmap.put(" ", 0x00); // 0
        charmap.put("*", 0x63); //
        charmap.put("=", 0x48); // 72
        charmap.put("°", 0x63); // 99
        charmap.put("top", 0x01);
        charmap.put("topRight", 0x02);
        charmap.put("bottomRight", 0x04);
        charmap.put("bottomLeft", 0x08);
        charmap.put("bottom", 0x10);
        charmap.put("bottomRight", 0x20);
        charmap.put("topRight", 0x40);
        charmap.put("middle", 0x80);

    }

    public static final int BRIGHT_DARKEST = 0;
    public static final int BRIGHT_DEFAULT = 2;
    public static final int BRIGHT_HIGHEST = 7;

    GpioPinDigitalOutput clk = null;
    GpioPinDigitalMultipurpose din = null;
    GpioController gpio = null;
    int digit[] = new int[4];

    int ADDR_AUTO = 0x40;   // 64 0b01000000
    int ADDR_FIXED = 0x44;  // 68
    int START_ADDR = 0xc0;  // 192 0b11000000
    int BRIGHTNESS = 0x88;  // 136 0b10001111 + {bright 1-7}
    int COLON = 0x80;  // 128
    int sleepDelay = 1;

    int brightness = BRIGHT_DEFAULT;
    boolean colon = false;

    /**
     * Pass the RaspiPin.GPIO_xx for the clock and digital pin
     *
     * @param gpio
     * @param clock
     * @param digital
     * @param brightness
     */
    public TM1637(GpioController gpio) {
        this(gpio, RaspiPin.GPIO_00, RaspiPin.GPIO_01);
    }

    /**
     * Create the instacne for the passed clock and data pin
     *
     * @param gpio
     * @param clock
     * @param data
     */
    public TM1637(GpioController gpio, Pin clock, Pin data) {
        super(gpio);

        clk = gpio.provisionDigitalOutputPin(clock, "tm1637clk", PinState.LOW);
        din = gpio.provisionDigitalMultipurposePin(data, PinMode.DIGITAL_OUTPUT);
        digit[0] = charmap.get("8");
        digit[1] = charmap.get("8");
        digit[2] = charmap.get("8");
        digit[3] = charmap.get("8");
        clk.high();
        din.high();
    }

    @Override
    public void clear() {
        //--- All segement for each digit
        show("    ", 0, false);

    }

    @Override
    public void show(String digits) {
        show(digits, BRIGHT_DEFAULT, false);
    }

    //**************************************************************************
    //*** API
    //**************************************************************************
    /**
     * Display the 4 digits
     */
    public void show(String digits, int brightness, boolean colon) {
        for (int i = 0; i < 4; i++) {
            try {
                if (charmap.get("" + digits.charAt(i)) != null) {
                    digit[i] = charmap.get("" + digits.charAt(i));

                } else {
                    digit[i] = charmap.get(" ");
                }

            } catch (IndexOutOfBoundsException ex) {
                break;
            }
        }

        this.colon = colon;
        this.brightness = brightness;

        sendData();
    }

    /**
     * Show the digit at the given index
     *
     * @param digit
     * @param index
     */
    public void showDigit(String num, int index) {
        try {
            if (charmap.get(num) != null) {
                digit[index] = charmap.get(num);

            } else {
                digit[index] = charmap.get(" ");

            }
            sendData();

        } catch (ArrayIndexOutOfBoundsException ex) {

        }

    }

    public void setBrightness(int level) {
        this.brightness = level;
        sendData();
    }

    public int getBrightness() {
        return brightness;
    }

    public void setColon(boolean colon) {
        this.colon = colon;
        sendData();
    }

    public boolean getColon() {
        return colon;
    }

    //**************************************************************************
    //*** Private
    //***************************************************************************
    /**
     * Start sequence
     */
    private void begin() throws InterruptedException {
        din.low();
        Thread.sleep(sleepDelay);
    }

    private void sendData() {
        try {
            System.out.println("SHOWING DIGIT AS BYTE " + digit[0] + "," + digit[1] + "," + digit[2] + "," + digit[3]);
            begin();
            writeByte(ADDR_AUTO);
            end();

            begin();
            writeByte(START_ADDR);
            for (int i = 0; i < 4; i++) {
                int data = digit[i];
                if (colon && (i == 1)) data = data | COLON;
                writeByte(data);

            }
            end();

            begin();
            writeByte(BRIGHTNESS + brightness);
            end();

        } catch (InterruptedException ex) {

        }
    }

    private void end() throws InterruptedException {
        din.low();
        Thread.sleep(sleepDelay);
        clk.high();
        Thread.sleep(sleepDelay);
        din.high();
        Thread.sleep(sleepDelay);
    }

    private void writeBit(int bit) throws InterruptedException {
        clk.low();
        Thread.sleep(sleepDelay);
        if (bit != 0) {
            din.high();
            Thread.sleep(sleepDelay);

        } else {
            din.low();
            Thread.sleep(sleepDelay);
        }
        clk.high();
        Thread.sleep(sleepDelay);
    }

    private void writeByte(int b) throws InterruptedException {
        // System.out.println("Wrinting byte " + b);
        din.setMode(PinMode.DIGITAL_OUTPUT);
        //--- Consume bit by bit
        for (int i = 0; i < 8; i++) {
            writeBit(b & 0x01);
            b = b >> 1;
        }

        //--- Wait for ack
        clk.low();
        Thread.sleep(sleepDelay);
        din.setMode(PinMode.DIGITAL_INPUT);
        clk.high();
        Thread.sleep(sleepDelay);

        int ack = din.getState().getValue();
        // System.out.println("Ack:" + ack);
        din.setMode(PinMode.DIGITAL_OUTPUT);
        clk.low();
        Thread.sleep(sleepDelay);

    }



}
