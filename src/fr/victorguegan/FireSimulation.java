//
//  Copyright 2013 the original author or authors.
//
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
//
//
//  FireSimulation.java
//  
//
//  Created by Frederik Vanggaard on 3/28/13.
//
//  Contact: contact@drudoo.com
//  
//

public class FireSimulation {
	private static int x;
	private static int y;
	private static int time;

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Height is not specified. Using default value of 400px");
			x = 400;
			System.out.println("Width is not specified. Using default value of 500px");
			y = 500;
			System.out.println("Time is not specified. Using default value of 100ms");
			time = 100;
		} else {

			try {
				x = Integer.parseInt(args[0]);
			} catch (Exception e) {
				System.out.printf("Invalid Input %s. Using default value of 400px\n", e.getMessage());
				x = 400;
			}

			if (args.length < 2) {
				System.out.println("Width is not specified. Using default value of 500px");
				y = 500;
				System.out.println("Time is not specified. Using default value of 100ms");
				time = 100;
			} else {
				try {
					y = Integer.parseInt(args[1]);
				} catch (Exception e) {
					System.out.printf("Invalid Input %s. Using default value of 500px\n", e.getMessage());
					y = 500;
				}

				if (args.length == 2) {
					System.out.println("Time is not specified. Using default value of 100ms");
					time = 100;
				} else {
					try {
						time = Integer.parseInt(args[2]);
					} catch (Exception e) {
						System.out.printf("Invalid Input %s. Using default value of 100ms\n",e.getMessage());
						time = 100;
					}
				}
			}
		}

		GUI gui = new GUI(x,y);
		gui.GameTimer(time);
	}
}