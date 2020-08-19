/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: Java Examples
 * FILENAME      :  TM1637Example.java
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

import com.pi4j.component.sevensegment.impl.TM1637;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.RaspiPin;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sbodmer
 */
public class TM1637Example {

    public static void main(String args[]) {
        System.out.println("<--Pi4J--> TM1637Example ... started. " + new Date());

        GpioController gpio = GpioFactory.getInstance();
        TM1637 tm = new TM1637(gpio, RaspiPin.GPIO_00, RaspiPin.GPIO_07);

        try {
            tm.show("1234", 7, false);
            Thread.sleep(5000);
            tm.show("4321", 1, true);
            Thread.sleep(5000);
            tm.clear();
            Thread.sleep(5000);
            tm.show("helo", TM1637.BRIGHT_DEFAULT, false);
            Thread.sleep(5000);
            tm.show("helo", TM1637.BRIGHT_DARKEST, false);
            tm.showDigit("-", 3);
            Thread.sleep(1000);
            tm.showDigit("-", 2);
            Thread.sleep(1000);
            tm.showDigit("-", 1);
            Thread.sleep(1000);
            tm.showDigit("-", 0);
            Thread.sleep(1000);
            tm.clear();

        } catch (InterruptedException ex) {

        }
        gpio.shutdown();
    }
}
