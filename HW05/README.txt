-------------------------------------------------------------------------------
BallWorld Demo Application(HW05) README

-------------------------------------------------------------------------------

QuickStart Guide For Running the BallWorld demo Application 
 
	1.) The BallWorld Demo Application demonstrates an application where a user can create animated balls of different styles
		by providing class names of the desired ball type. The balls can also change its strategy dynamically. There is also 
		a button to clear the screen of all balls
		
	2.) Type the shortened name of an update strategy into the text field on the left.
		Available strategies : 
		from HW04--'Straight' 'Breathing' 'Change1' 'ColorChanging' 'Drunken' 'Wandering'		                      
		from HW05--'Swallow' 'Fat' 'Flash' 'Collide' 'Spawn' 
		Among them:
		Interaction criteria is that the balls must have collided: 'Swallow' 
        Interaction critera is something other than having collided: 'Fat' 'Flash'
		
		Type the shortened name of an paint strategy into the text field on the right.
		Available strategies: 'Rectangle' 'Ball' 'Ellipse' 'Square'  'Fish1' 'NiceFish' 'SheepImage' 'SoccerImage' 'SonicImage'
		
	3.) "Make A Ball" button will make a ball with the strategy selected on the top drop list.
	
	4.) "Combine!" button will dynamically create a strategy that is the combination of the strategies selected on top and bottom lists.
	 The new strategy is placed back into both drop lists and can be used again for combining. For instance, add then combine 
	 "ColorChanging" and "Breathing" to make a ball that curves and breathes.
	 
	5.) "Make Switcher" button will make a ball, initially, ones that go straight.  
	
	6.) Clicking "Switch" button will cause all Switcher balls ever made to switch behaviors to whatever is the selected strategy on the top
	 drop list.	 
	 
  	7.) To run the application, you can right click and select Run As -> Java application 
  		on any of the following in the package explorer pane:
  			- the top folder 'HW05'
  			- the 'HW05/src' folder
  			- the 'HW05/src/controller' package
  			- the class inside controller package 'Controller.java' that contains the main method