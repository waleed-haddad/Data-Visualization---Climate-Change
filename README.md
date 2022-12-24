CSC207 PROJECT FINAL REPORT

FINAL Project Report
Created 2022.12.06

Climate Change Data Visualizer
Jay Patel
Waleed Haddad
Aditya Kumar
Ryan Reza


Github Link: https://github.com/waleed-haddad/Data-Visualization---Climate-Change


SECTION 1: REPORT SUMMARY
For this project, the group decided to create a Data Visualizer that will display climate change data through an interactive world map. The focus was set on displaying carbon emissions per capita of countries on an interactive world map which shows the relative contributions each country is making toward global warming.
This project is inspired by the Urban Tree Data Visualizer Project, but expanded to the scope of the whole world and enables the user to select/search a country and display its according data, along with visual accessibility features.

SECTION 2: PROCESS DOCUMENTATION

2.1. SPRINT 1 OVERVIEW

2.1.1 Sprint Overview: November 18 to November 25  
The goal for this sprint was to learn the basics surrounding the project. This included learning how to retrieve and store information in an organized fashion from CSV files containing information about every country. It also included learning how to use the World Map API and its functionality.  

2.1.2 Stories Selected for this Sprint:
1.0 - Develop a Country hashmap with data 
This is a user story not mentioned in the original design document. It consisted of File IO work, retrieving information from a database, and putting it into a hashmap with Country objects as values and country names as values. The Country objects themselves were also made during this sprint, as well as World objects which are simply collections of Country objects.
1.1 - Color countries based on carbon emission per capita 
During this week, the focus of this user story was set on how colouring would work rather than which countries should be coloured what. 
1.2 - Select country and display data 
During this week, the focus on this user story was also set on functionality rather than which country should display what data.   

2.1.3 Team Capacity:
For this sprint, it was decided as a team that a basic display of the map should be realized (without any features), and each member was expected to begin working on their respective design pattern. 

2.1.4 Participants:
Ryan Reza - Worked on the foundation of the Iterator Pattern to enable colouring and ranking of the countries
Jay Patel - Worked on the foundation of the Strategy Pattern to implement the different accessibility views.
Waleed Haddad - Worked on retrieving data from CSV files and storing information (User Story 1.0)
Aditya Kumar - Worked with World Map API to display the map and add colour (User Story 1.2).

2.1.5 Tasks Completed:
All tasks completed were covered in the team capacity section. By the end of the sprint, a world map was visible, and all data for each country (along with country objects and world objects) was available. Progress was also made in every design pattern planned for this project.

2.2. SPRINT 1 PRODUCT BACKLOG
1.0 - Develop a Country hashmap with respective data (New)
1.2 - Select country and display data 
 
2.3. SPRINT 1 CODE REVIEWS
Story Reviewed
Name of Reviewer
Pull Request Link
feature/1.0-develop-country-hashmap-with-data
Aditya Kumar 
https://github.com/waleed-haddad/Data-Visualization---Climate-Change/pull/5
feature/iterator-design-pattern
Aditya Kumar 
https://github.com/waleed-haddad/Data-Visualization---Climate-Change/pull/4
feature/1.2-select-country-and-display-data 
Waleed Haddad 
https://github.com/waleed-haddad/Data-Visualization---Climate-Change/pull/3



2.4 SPRINT 1 RETROSPECTIVE
Participants: Ryan Reza, Waleed Haddad, Jay Patel, Aditya Kumar 
Through this sprint, the group was able to set a solid foundation for the rest of the project. Each member could complete the assigned tasks, and pull requests were handled well. During the meeting, the group also took some time to describe their work to the rest. This was a great idea as it allowed everyone to better understand how the final project is expected to look. Moving forward, however, the group wanted to improve the overall communication between members. Occasionally, some members had written code formatted differently from how the other members had expected. Additionally, some git actions were unclear and unorganized (incorrect titles, untimely pulls), and optimizing them in the next sprint was prioritized. 

3.1. SPRINT 2 OVERVIEW
3.1.1 Sprint Overview: November 25 to December 2
This sprint aimed to implement the main high-priority functionality into the project, as the basics were now understood and covered. The highest priority tasks were searching countries and displaying their data, colouring the countries on the map and setting up the different views, such as colourblind mode. 

3.1.2 Stories Selected for this Sprint:
2.1 - Search Countries and get CO2 emissions
During this week, the search bar for the map UI was also worked on, and by the end, a functioning search bar was used to search up countries and get their relevant CO2 emissions.
2.2 - Various Modes and Views
During this week, the accessibility modes and the implementation of their views were the main focus. The outlining code for the colourblind mode and the dark mode was worked on using the Country object’s colour attribute and isSelected attribute.
2.3 - Colour Countries Based on Carbon Emission Per Capita
Utilized the iterator pattern to assign colours to each country according to their carbon emissions data. Set colours based on intervals of carbon emissions that allowed for the best comparisons between the countries.
2.4 - Undo and Return to Default
Implemented the Command design pattern to have to undo functionality. Turned the user’s actions into commands, storing them inside a CommandHistory class which contains an ArrayList. Created the concrete command classes which have to execute and unexecute (undo) methods. Also created the MapEditor class, which handles all of the logic for the code, linking to the MapListener, which invokes the commands. 
2.5 - Integrate Search and Undo
Integrated the Search Button to work with the Command Pattern and the undo functionality as well. The Search Button had to reset the views for all the countries in the MapView so the CommandHistory had to be used to ensure the previously selected countries were kept. Also had to ensure that the ability to undo and unselect a country worked alongside the search button accordingly.
2.10 - Colourblind mode
Colourblind mode was integrated using the Country object’s colour attribute and isSelected attribute. Appropriate colours were chosen that would allow for the best experience for a user experiencing colour blindness. This was integrated with the Strategy Pattern.

3.1.3 Team Capacity:
For this sprint, it was decided as a team that the core high-priority user stories were implemented to the best of each member’s abilities. Additionally, any design patterns that were not started in the first sprint were to now be implemented either completely or near completion.

3.1.4 Participants:
Ryan Reza - Worked on User Story 2.3 (Colour Countries Based on Carbon Emission Per Capita, more advancements on Iterator pattern)
Jay Patel - Worked on User Story 2.2 (Various Modes and Views), User story 2.10 (Colourblind mode)
Waleed Haddad - Worked on User Story 2.4 (Implementing Command Pattern for Undo)
Aditya Kumar - Worked on User Story 2.1 (Search Countries and get CO2), User Story 2.5(Integrate Search and Undo)

3.1.5 Tasks Completed:
By the end of this sprint, there was a working interactive world map where each country could be selected/unselected, and the CO2 emissions for that country would be displayed. Additionally, there was substantial work done on the alternate views and the foundational code for said views. Finally, the undo button’s first version was implemented, and in conjunction with unselecting countries, allowed the user to now go back on commands that were inputted.

3.2. SPRINT 2 PRODUCT BACKLOG
2.1 - Search Countries and get CO2 emissions
2.2 - Various Modes and Views
2.3 - Colour Countries Based on Carbon Emission Per Capita
2.4 - Undo and Return to Default
2.5 - Integrate Search and Undo
2.10 - Colourblind mode


3.3. SPRINT 2 CODE REVIEWS
Story Reviewed
Name of Reviewer
Pull Request Link
feature/2.4-First commit for Command Interface implementation
Aditya Kumar
https://github.com/waleed-haddad/Data-Visualization---Climate-Change/pull/7
Feature/2.2 various views


Ryan Reza
https://github.com/waleed-haddad/Data-Visualization---Climate-Change/pull/10
Feature/2.3 colour countries with iterator
Jay Patel
https://github.com/waleed-haddad/Data-Visualization---Climate-Change/pull/11
feature/2.1 search country and get CO2 emissions
Waleed Haddad
https://github.com/waleed-haddad/Data-Visualization---Climate-Change/pull/8



3.4 SPRINT 2 RETROSPECTIVE
Participants:  Ryan Reza, Waleed Haddad, Jay Patel, Aditya Kumar
Through this sprint, the members of the group managed to implement most of the high priority tasks that were originally planned in the first phase of the project. Every member in the group reviewed at least one pull request, so the code written in this sprint was thoroughly reviewed and fit well into the program. Following up on the improvements suggested in the last sprint, more team meetings were held so that members had better communication and clarity between one another and conflicting code was avoided.
The group faced major roadblocks when it came to using Git to commit and push changes, especially with multiple branches all pulling from and pushing to develop branches. In the end, some user stories had to be scrapped while others had to be added, streamlining the process further and setting up the group for a strong finish in the final sprint.

4.1. SPRINT 3 OVERVIEW
4.1.1 Sprint Overview: December 2 to December 7
The goal of this sprint was to add any final changes that were made to our previous code. This included adding docstrings to any classes that were missing them and fixing any bugs that were brought up with our project. It also consisted of implementing buttons, a search bar and legends for the accessibility displays.

4.1.2 Stories Selected for this Sprint:
2.6  Implement Undo Button
During this week, the undo button was changed to be its own class, integrating it into the Observer pattern.
2.7 Displaying Map Legend
Displaying the map legend with colours referring to a specific interval of carbon emissions. The colours are set based on the view chosen
2.8 Implement the Accessibility User Interface
Created buttons for the different accessibility views (Default View, Colour Blind Mode, Dark Mode) through the Observer Pattern created earlier.
2.9 - Dark Mode (New)
This user story was not initially a specific part of the user stories but was an extension to 2.2. The Dark Mode worked on changing the colours and the general elements of the project to be more darkly coloured.
2.11 - Rank Countries Based on Carbon Emission Per Capita
Displayed the rank of the country as part of the display data when any country is selected. The rank was each country was stored when the iterator was generated through the Iterator Pattern.

4.1.3 Team Capacity:
By the end of this sprint, full implementation of every design pattern used for the project was complete. Additionally, all classes were tested to ensure functionality was correct. Moreover, all features of the project were functioning, including all UI components and non-UI components. Finally, the final code would be merged into the main branch. 

4.1.4 Participants:
Ryan Reza - Completed and fixed the colouring and ranking of countries and created a legend for emission ranges - User story 2.11
Jay Patel - Completed User Stories 2.7, 2.9 (Strategy Pattern) and implemented the legend according to the colours of the current display. 
Waleed Haddad - Completed User Stories 2.6
Aditya Kumar - Completed User Story 2.8. Implemented buttons for switching between different displays.

4.1.5 Tasks Completed:
By the end of this sprint, there was a complete working interactive world map where each country could be selected/unselected, and the CO2 emissions for that country would be displayed. Additionally, the functionality of each view was complete, and there was a way to alternate between the views. Moreover, the undo button’s final version was implemented and made its own class to support the other buttons created for each display. Lastly, all the completed code was merged into the main branch for submission.

4.2. SPRINT 3 PRODUCT BACKLOG
2.6  Implement Undo Button
2.7 Displaying Map Legend
2.8 Implement the Accessibility User Interface
2.9 - Dark Mode (New)
2.11 - Rank Countries Based on Carbon Emission Per Capita

4.3. SPRINT 3 CODE REVIEWS
Story Reviewed
Name of Reviewer
Pull Request Link
feature/2.3-color-countries-range
Aditya Kumar
https://github.com/waleed-haddad/Data-Visualization---Climate-Change/pull/21
feature/2.6-Undo-Button_File
Ryan Reza
https://github.com/waleed-haddad/Data-Visualization---Climate-Change/pull/22
feature/2.7-displaying-map-legend
Ryan Reza
https://github.com/waleed-haddad/Data-Visualization---Climate-Change/pull/25
feature/2.8-implement-accessibility-user-interface
Jay Patel
https://github.com/waleed-haddad/Data-Visualization---Climate-Change/pull/24



4.4 SPRINT 3 RETROSPECTIVE
Participants: Ryan Reza, Waleed Haddad, Jay Patel, Aditya Kumar 
Through this sprint, the group was able to complete an interactive world map which had various such as undo, different displays to accommodate accessibility needs, and a functional search bar. During the meeting, the group discussed any issues that were currently present with their aspect of work and described their current point as the aspect of their work. This proved to be very beneficial as everyone was able to help each other to point out where they were going wrong. Additionally, the communication of the group improved, allowing us to write code in a way that was usable by everyone. Moving forward, the group wanted to be able to work in unison as this would allow others to continuously work on the project however since some members were experiencing issues with their code, it delayed some aspects of the program. Additionally, improvement to the GUI aspect can improve the project’s view and appeal to users.


SECTION 3: SUMMARY

Upon completing the project, the group was extremely content with the final product as the initial general functionality and vision for the project was realized. The team had effectively created an interactive world map which displayed all countries with their various carbon emissions per capita in different colours (under set emissions ranges). A search feature was also implemented, allowing users to search for a specific country by its name, which would then display data for that specific country on the screen. These UI features were integrated with the Observer pattern as originally planned. An additional feature was added where a rank for each country was also displayed; this rank indicated its standing of how great its carbon emissions are compared to the rest of the world. The ranking and colouring of each country heavily utilized the Iterator pattern to loop through each country and assign colours/ranks as originally planned. Moreover, the process of being able to select and unselect countries was handled by the Command pattern. Accessibility features were handled by the Strategy pattern; users can view the world map in a colour-blind mode and night mode on top of the default mode, as was originally planned. Overall, all design patterns were utilized effectively to create the general functionality of the project and implement a handful of side features initially planned for the data visualizer. 

Throughout the project's construction, several aspects initially planned had to be narrowed or scrapped due to time constraints. Starting with the Observer pattern, initial plans involved allowing users to zoom in and out of the map using a slider, but this ultimately was never realized. Additionally, one of the goals was to have a “top 10” ranking displayed on the screen, but it was ultimately decided to include ranking alongside carbon emission data to not exclude rankings for other countries aside from the ones that would be in the top 10. On top of the ranking, however, there was also a desire to include other types of information, such as fossil fuel usage and climate information for each country. This feature, unfortunately, also had to be cut. A proper ranking for carbon emissions, as well as the other aforementioned information, would have been handled by the Strategy and Iterator pattern. In general, due to time constraints, the focus was put on the main features of the design patterns to be implemented. In the future, the plan is to continue working on this project and complete user stories that had to be scrapped.
