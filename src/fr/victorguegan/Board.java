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
//  Board.java
//  
//
//  Created by Frederik Vanggaard on 3/28/13.
//
//  Contact: contact@drudoo.com
//  
//

import javax.swing.JPanel;
import java.awt.*;

public class Board extends JPanel {
	
	private int[][] cellArray;
	private int x;
	private int y;

	public Board(int x, int y, int[][] cellArray) {
		this.cellArray = cellArray;
		this.x = x/5;
		this.y = y/5;

		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(null);
		boardPanel.setPreferredSize(new Dimension(x,y));
	}

	public void paintComponent(Graphics g) {

		for (int i = 0; i < this.x; i++) {
			for (int j = 0; j < this.y; j++) {
				

				if (cellArray[i][j] == 1) {
					g.setColor(Color.red);
				}

				if (cellArray[i][j] == 2) {
					g.setColor(Color.gray);
				}

				if (cellArray[i][j] == 3) {
					g.setColor(Color.white);
				}

				if (cellArray[i][j] == 4) {
					g.setColor(Color.green);
				}

				if (cellArray[i][j] == 5) {
					g.setColor((Color.green).darker());
				}

				if (cellArray[i][j] == 6) {
					g.setColor(Color.blue);
				}

				if (cellArray[i][j] == 0) {
					g.setColor(Color.orange);
				}

				g.fill3DRect(j*5, i*5, 5,5, true);	
			}
		}

		repaint();

	}
}