This project focused on identifying and mitigating security vulnerabilities for Artemis Financial, a consulting firm seeking to modernize its RESTful web API. The goal was to implement industry-standard security layers to protect sensitive financial data during transfer and storage.

Briefly summarize your client, Artemis Financial, and its software requirements. Who was the client? What issue did the company want you to address?

Artemis Financial is a financial consulting company that sought to update its outdated API to meet modern security guidelines and provide the best possible protection for transmitting sensitive financial data. The company requested that the team implement up-to-date cryptographic standards and secure data handling practices to ensure the application met current market standards.

What did you do well when you found your client’s software security vulnerabilities? Why is it important to code securely? What value does software security add to a company’s overall well-being?

The software’s primary vulnerabilities were a lack of solid encryption and the use of outdated libraries, which left it susceptible to various hacking tactics. Addressing these flaws by writing secure software is vital because it protects private customer information, safeguards the firm's data, and ensures compliance with local regulations. This security adds value to the company’s well-being by fostering customer confidence, ensuring clients trust the company to handle delicate financial services without the risk of financial loss.

Which part of the vulnerability assessment was challenging or helpful to you?

The most challenging part of the assignment was integrating and navigating the vulnerability scan. It was difficult to determine the best way to remediate the vulnerabilities, as many were complex and did not have "quick fixes." This was also the most helpful part of the project, as it taught me about the wide range of vulnerabilities that affect applications and how to be discerning when reading vulnerability reports. Additionally, learning to implement the SHA-256 hashing algorithm was a key takeaway, as it is a fundamental skill for data encryption.

How did you increase layers of security? In the future, what would you use to assess vulnerabilities and decide which mitigation techniques to use?

I increased the layers of security by adding the SHA-256 hashing algorithm to ensure all data remains secure while being transferred over the internet. Even if a bad actor intercepted the information, they would be unable to decode it. In the future, I will continue to use the OWASP Dependency-Check and vulnerability trackers to identify risks and implement specific changes based on those reports to maintain a secure environment.

How did you make certain the code and software application were functional and secure? After refactoring the code, how did you check to see whether you introduced new vulnerabilities?

After making changes—such as updating libraries or removing dependencies—I consistently checked the code and re-ran the vulnerability reports. This iterative process ensured that all identified vulnerabilities were addressed and that the refactoring process did not introduce any new security gaps or "transitive" vulnerabilities.

What resources, tools, or coding practices did you use that might be helpful in future assignments or tasks?

I gained deeper knowledge of the Maven and Spring Boot frameworks, which will be vital in future assignments and professional roles. I also learned the practical application of cryptography and hashing algorithms, which are essential for any organization sending data over the internet to ensure information remains safe and untampered with.

Employers sometimes ask for examples of work that you have successfully completed to show your skills, knowledge, and experience. What might you show future employers from this assignment?

If asked by a future employer, I would showcase the Vulnerability Assessment Report and the Refactored Codebase. These artifacts demonstrate my ability to identify complex security flaws in existing code, implement advanced cryptographic solution, verify that security patches do not break the functional requirements of the business.
