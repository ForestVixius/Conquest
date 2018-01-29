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
//  Cells.java
//  
//
//  Created by Frederik Vanggaard on 3/28/13.
//
//  Contact: contact@drudoo.com
//  
//

import java.util.Random;

public class Cells {
	
	private int[] surroundingCells = new int[9];
	private int cellState;

	public Cells(int[] surroundingCells) {
		this.surroundingCells = surroundingCells;
		cellState = this.surroundingCells[4];

		Random rand = new Random();


		//Wall = 0
		//Fire = 1
		//Ash = 2
		//Ground = 3
		//Tree = 4
		//Pine_Tree = 5
		//Water = 6



		switch (cellState) {
			//Wall
			case 0: { 
				cellState = 0;
				break;
			}

			//Fire
			case 1: {
				for (int i : this.surroundingCells) {
					if (i == 6) {
						i = 3;
						cellState = 3;
					}

					if (i != 6) {
						if (rand.nextInt(3) == 0) {
							cellState = 2;
						} else {
							cellState = 1;
						}
					}
				}
				break;
			}

			//Ash
			case 2: {
				if (rand.nextInt(100) == 0) {
					cellState = 2;
				} else {
					cellState = 3;
				}
				break;
			}

			//Ground
			case 3: {
				if (rand.nextInt(200) == 0) {
					if (rand.nextInt(5) == 0) {
						cellState = 5;
					} else {
						cellState = 4;
					}
				} else {
					cellState = 3;
				}
				break;
			}

			//Tree
			case 4: {
				for (int i : this.surroundingCells) {
					if (i == 1) {
						if (rand.nextInt(3) == 0) {
							cellState = 1;
						} else {
							cellState = 4;
						}
					}
				}

				if (rand.nextInt(100000) == 0) {
					cellState = 1;
				}

				break;
			}

			//Pine_Tree
			case 5: {
				for (int i : this.surroundingCells) {
					if (i == 1) {
						if (rand.nextInt(10) == 0) {
							cellState = 1;
						} else {
							cellState = 5;
						}
					}
				}

				if (rand.nextInt(100000) == 0) {
					cellState = 1;
				}

				break;
			}

			//Water
			case 6: {
				for (int i : this.surroundingCells) {
					if (i == 1) {
						cellState = 3;
					} else {
						cellState = 6;
					}
				}
				break;
			}
		} 
		
		this.surroundingCells[4] = cellState;
	}

	public int[] returnCells() {
		return this.surroundingCells;
	}

}