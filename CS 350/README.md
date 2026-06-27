This is the repository for the course project for the class CS 350: Emerging System Architecture and Technology whiched focused on the concepts and cooding of embedded systems. The project in this repositiory is the culmination of what we learned to create a thermostat that works off of a breadboard connected to a Raspberry Pi.

Reflection:

Summarize the project and what problem it was solving.

The objective of this project was to design and implement a working embedded thermostat system capable of reading simulated ambient temperatures and responding to user settings. The system allows users to interactively increase or decrease the target temperature via physical buttons. Ideally suited to interface with residential or commercial HVAC systems, this project solved the problem of creating a responsive, automated system loop that dynamically switches states to heat or cool an environment based on user preferences.

What did you do particularly well?

I successfully programmed the system's core functionality, mapped the hardware states to the Python code, and controlled the LED indicators accurately while demonstrating strong engineering adaptability when hardware constraints arose. When certain physical components on my breadboard failed to function, I pivoted to implement a console-based display system to verify the program logic, which was later proven flawless when cross-device testing confirmed that the software worked perfectly on an alternative setup. 

Where could you improve?

To improve in the future, I could enhance my hardware troubleshooting and diagnostic procedures by spending more time testing individual jumper wires, verifying connections with a multimeter, or acquiring replacement components like an LCD screen to ensure the physical layout fully functions.

What tools and/or resources are you adding to your support network?

Through this project, I significantly expanded my professional and technical support network by adding practical experience in configuring, programming, and troubleshooting a Raspberry Pi single-board computer. Additionally, I integrated the official Raspberry Pi foundation documentation into my resources for leveraging Python libraries in hardware interaction, while gaining valuable hands-on knowledge regarding how to interface code directly with physical peripherals like GPIO buttons, LEDs, and external display screens.

What skills from this project will be particularly transferable to other projects and/or course work?

Several critical skills gained from this project will translate directly to future computer science coursework and professional development, notably an advanced fluency in Python applied specifically to low-level hardware control instead of traditional software applications. Furthermore, I mastered the logical frameworks necessary to design deterministic system state machines, while gaining a deep understanding of physical breadboard wiring and how discrete electronic components communicate together under the control of software logic.

How did you make this project maintainable, readable, and adaptable?

To ensure this project aligns with industry clean-code standards, I heavily focused on functional decoupling by breaking the architecture down into small, single-purpose functions. This modular design makes the system highly maintainable because any necessary bug fixes or feature changes are strictly confined to a single function rather than altering a massive main loop. Additionally, I maintained readability and adaptability by adopting a minimalist coding approach, utilizing the leanest logic possible to eliminate code clutter and keep the program highly optimized for future hardware expansions.
