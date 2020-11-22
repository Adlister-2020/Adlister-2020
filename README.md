# About the Project
This is a Craigslist / Offerup Clone using Java EE and MVC pattern to implement CRUD functionalities.


## Table of Contents
1. [Setup Instruction](https://github.com/Adlister-2020/Adlister-2020/tree/li-wang#setup-instruction)
2. [User Stories](https://github.com/Adlister-2020/Adlister-2020/tree/li-wang#user-stories)
3. [Feature List](https://github.com/Adlister-2020/Adlister-2020/tree/li-wang#feature-list)
4. [Database Design](https://github.com/Adlister-2020/Adlister-2020/tree/li-wang#database-design)
5. [Contribution](https://github.com/Adlister-2020/Adlister-2020/tree/li-wang#contribution)

### Setup Instruction
Clone repo, open with Intellij, run **migration.sql** to set up the database, run main method in **Seeds.java** to load data.
Create Config.java in a package directory. Sample setup:
<img width="640" alt="Screen Shot 2020-11-22 at 4 29 10 PM" src="https://user-images.githubusercontent.com/40813295/99918950-fa15e480-2cdf-11eb-8f3e-ea3f608b2f36.png">
Then start Tomcat server to view application.

Make sure to set up Tomcat and MySQL correctly. 

### User Stories
<details>
  <summary>Guest</summary>

  1. [x] As a **guest**, when I ***visit the url*** I expect to ***view all ads***.  
  
  2. [x] As a **guest**, when I ***click an ad*** I expect to ***view the ad***. 
  
  3. [x] As a **guest**, when I ***go to the landing page*** I expect to ***search the ads by keywords***.    
  
  4. [x] As a **guest**, when I ***go to the landing page*** I expect to ***sort the ads by category***.  
  
  5. [x] As a **guest**, when I ***click the register button*** I expect to ***be able to register***. 
  
  6. [x] As a **guest**, when I ***click the about page*** I expect to ***see About Us page***. 
</details>

<details>
  <summary>Registed User</summary>

  1. [x] As a **user**, when I ***log in*** I expect to ***view my profile page which displays all my ads***.  
  
  2. [x] As a **user**, when I ***log in*** I expect to ***perform all guest features***. 
  
  3. [x] As a **user**, when I ***log in*** I expect to ***CRUD all my own ads***.    
  
  4. [x] As a **user**, when I ***view an ad*** I expect to ***see its creator's contact information***.  
  
  5. [x] As a **user**, when I ***visit other user's profile*** I expect to ***be able to see it***. 
  
  6. [x] As a **user**, when I ***visit my profile page*** I expect to ***be able to edit it***. 
  
  7. [x] As a **user**, when I ***log in*** I expect to ***be able to change my password***. 
  
  8. [x] As a **user**, when I ***click log out*** I expect to ***log out***. 
  
  9. [x] As a **user**, when I ***click delete account*** I expect to ***delete my account***. 
</details>

<details>
  <summary>Admin</summary>

  1. [x] As an **admin**, when I ***log in*** I expect to ***view admin dashboard page***.  
  
  2. [ ] As an **admin**, when I ***visit admin dashboard*** I expect to ***view the ads table and see all the info including total ads***. 
  
  3. [ ] As an **admin**, when I ***view ads table*** I expect to ***be able to perform CRUD functionality on ads***. 
  
  4. [ ] As an **admin**, when I ***visit admin dashboard*** I expect to ***view the users table and see all the info including total users***.    
  
  5. [ ] As an **admin**, when I ***view users table*** I expect to ***be able to perform CRUD functionality on users***. 
  
  6. [ ] As an **admin**, when I ***visit admin dashboard*** I expect to ***view the categories table***.  
  
  7. [ ] As an **admin**, when I ***view categories table*** I expect to ***be able to perform CRUD functionality on categories***. 
</details>

<details>
  <summary>Super Admin(optional)</summary>

  1. [ ] As a **super admin**, when I *log in* I expect to *view super admin dashboard page*.  
  
  2. [ ] As a **super admin**, when I *visit super admin dashboard* I expect to *be able to have all admin features*. 
  
  3. [ ] As a **super admin**, when I *visit super admin dashboard* I expect to *be able to CRUD admins*. 
</details>

### Feature List

<details>
  <summary>Finished features</summary>

  1. [x] Register user and login auth  
  
  2. [x] Login user can create ads
  
  3. [x] Page shows all ads
  
  4. [x] Page show individual ad  
    
  5. [x] User profile page lock down (only available for the logged in user)
   
  6. [x] Allow user to log out
  
  7. [x] Allows user to search through the ads in your database by title or description
  
  8. [x] Show the user's Ads on their profile page
  
  9. [x] Ensure usernames are unique
  
  10. [x] Dynamic navbar for logged in users and guests
  
  11. [x] Allow users to update and delete Ads
  
  12. [x] Allow users to update their profile information
  
  13. [x] Error Messages
  
  14. [x] Sticky Forms
  
  15. [x] Validate data before saving to database
  
  16. [x] Allow an Ad to have many categories
  
  17. [x] Allow users to search through ads by category
  
  18. [x] Allow an Ad to have an image
  
  19. [x] Intended Redirects
  
  20. [ ] Mobile responsiveness
  
  21. [x] Allow users to delete account
</details>

<details>
  <summary>Future features</summary>

  1. [ ] Implement a Mail API 
  
  2. [ ] Implement a Map/Geolocation API
  
  3. [ ] Password recovery
  
  4. [ ] Custom error/404 page 
  
  5. [ ] Subcategories 
  
  6. [ ] Super admin 
  
  7. [ ] Deployment 
</details>

### Database Design
<details>
  <summary>Diagram</summary>
    
</details>

### Contribution
**This list is in alphabetical order**
<details>
  <summary>Li Wang  <a href="https://github.com/liliwang1" target="_blank">GitHub</a></summary>
  
  1. User can choose categories when creating and ad.  
  2. Display categories of each ad.
  3. User can search ads by each category.
  4. Add README.md.
  5. Guest can visit About page.
</details>

<details>
  <summary>Michael Klanica <a href="https://github.com/michaelklanica" target="_blank">GitHub</a></summary>

  1.  
  2. 
  3. 
  4. 
</details>

<details>
  <summary>Robert De laRosa <a href="https://github.com/rdelarosa3" target="_blank">GitHub</a></summary>

  1.  
  2. 
  3. 
  4. 
</details>
  
<details>
  <summary>Rocco Paccione <a href="https://github.com/roccopaccione" target="_blank">GitHub</a></summary>

  1.  
  2. 
  3. 
  4. 
</details>
 
<details>
  <summary>Thomas Levi Crowder <a href="https://github.com/ThomasCrowder703" target="_blank">GitHub</a></summary>

  1.  
  2. 
  3. 
  4. 
</details>
