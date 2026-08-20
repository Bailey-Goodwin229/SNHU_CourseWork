Project Overview
This repository contains a fully functional Android inventory management application designed to track stock levels, manage records, and provide real-time status alerts. The project demonstrates a complete development lifecycle, moving from initial requirements gathering to user interface prototyping and database-driven code implementation.

Reflection & Course Journal
1. App Requirements, Goals, and User NeedsThe primary goal of this project was to develop an agile inventory management application that provides users with real-time updates when stock reaches critical thresholds. The app was designed to assist companies in seamlessly managing their operations by allowing users to add, remove, and update inventory items based on fluctuating stock levels. To ensure security and data integrity, the application features a robust login system where users can create secure accounts and authenticate. Both the inventory records and user account credentials are housed in local SQLite databases, ensuring that all data is securely stored, persistent, and accessible when needed.

2. User-Centered UI Design & Success
To support user needs and deliver a user-centered interface, the application utilizes four key screens:
Login Screen: Secures the application and handles user account creation.
Inventory Dashboard: Displays current stock and acts as the central hub.
Add Item Screen: Accommodates new entries into the system.
SMS Settings Screen: Empowers users to opt-in or out of real-time low-stock text notifications.
The UI design was intentionally kept simple and streamlined because warehouse workers must update inventory rapidly to keep pace with changing demands. The designs were successful because they prioritized intuitive user flow and direct access to core features. By avoiding unnecessary complexity and cluttered layouts, users can manage stock and configure real-time SMS updates efficiently without getting bogged down.

3. Coding Approach, Techniques, and Future Strategies
The development process was strategically broken down into three distinct, manageable phases:
Requirement Analysis: Establishing a comprehensive written plan based purely on core user requirements.
UI/UX Prototyping: Designing the user interface to preview the look, feel, and navigation of the app.
Functional Programming: Writing the backend logic and database integration to produce the final, working product.
This phased, multi-level design approach proved highly effective.Breaking the pipeline into planning, wireframing, and coding made the entire development process significantly smoother. I plan to apply this structured methodology to all my future engineering projects to ensure the final product remains strictly aligned with user needs and matches the original design intent.

4. Testing Processes and Revelations
Testing was conducted iteratively throughout the entire programming cycle. I consistently ran the application from the perspective of an end-user, executing every action and edge case possible. This hands-on testing revealed that executing tasks in specific, unexpected sequences caused unintended consequences that disrupted app functionality. It also highlighted UI elements that did not work as originally intended or lacked practical utility for the consumer. This rigorous testing process was vital; it drove continuous improvement, exposed critical bugs before finalization, and ultimately resulted in a much more stable, refined final product.

5. Innovation, Challenges, and Key Successes
Transitioning from static UI mockups to final database implementation required the most innovation and adaptability. Several features had to pivot from their original plans to better serve the user experience:
Dynamic Inputs: I innovated by designing an independent "Add Item" page, allowing users to define custom initial values rather than relying on automated defaults.
Functional Refactoring: I altered the stock modification system to accept direct keyboard input for precise number entries, moving away from incremental plus/minus buttons that would be too slow in a high-volume warehouse environment.
Overall, I was particularly successful during the UI design phase. Establishing a clear visual layout early on gave me an exceptional blueprint. This strong design foundation ultimately made programming the backend functionality much easier and enabled me to build a better-functioning application for the end-user.
