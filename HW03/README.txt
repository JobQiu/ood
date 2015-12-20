Author: zc22 Zhongjie Chen(JacobChen)
        ls53 Li Shen

How to run program: Right click the project -> run as java application.

Overview: This composition-based Ballworld program demonstrates the ability of 
          composition-based systems to add dynamically modifiable behaviors to a system.

Available functionality: 
1. Type the name of a strategy into the text field on the left. The available strategies are:
   Straight
   Color
   Breathing
   Curve
   Wander
   Speed
   
   And correspondingly, the ball will move like default(go straight); 
                                     change color; 
                                     change size; 
                                     turn itself; 
                                     move randomly; 
                                     slow down and speed up.
                                     
2. Click the "Add to Lists" button will then add the strategy to both the drop lists.

3. Click "Make Selected Ball" will make a ball with the strategy selected on the top drop list.

4. Clicking "Combine!" will dynamically create a strategy that is the combination of the strategies 
   selected on top and bottom lists. The new strategy is placed back into both drop lists and 
   can be used again for combining. For instance, add then combine "Curve" and "Breathing" to 
   make a ball that curves and breathes.
   
5. Clicking "Make Switcher" will make a ball, initially, ones that go straight.

6. Clicking "Switch!" will cause all Switcher balls ever made to switch behaviors to whatever is 
   the selected strategy on the top drop list. Switcher balls made later will have the same behavior 
   as whatever the previously made Switchers have.

    