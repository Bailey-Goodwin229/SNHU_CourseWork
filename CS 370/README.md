# CS 370: Current and Emerging Trends in Computer Science - Portfolio Reflection

## Project Reflection: Pirate Intelligent Agent

### 1. Work Overview: Given Code vs. Created Code
In Project Two, I developed a **Pirate Intelligent Agent** that utilizes a deep reinforcement learning algorithm to navigate a maze-like environment and reach a designated treasure. 

* **The Given Code:** The foundational infrastructure was pre-built, including the game environment mechanics (`TreasureMaze.py`), visualization tools, and the architectural setup of the Deep Q-Network (DQN) using Keras/TensorFlow. I was also provided with helper functions to handle the environment states, game resets, and reward/penalty rules.
* **The Created Code:** My responsibility was to implement the core **Q-Training Algorithm** within the main application loop. I wrote the code that governs the agent's action selection strategy by balancing **exploration** (choosing random moves to discover new pathways) and **exploitation** (leveraging known optimal paths via neural network predictions) using an epsilon-greedy approach. I also constructed the memory replay loops to train the neural network dynamically, ensuring that the model could successfully minimize loss and optimize its pathfinding behavior over hundreds of training epochs.

### 2. Connecting Learning to the Broader Field of Computer Science

#### What do computer scientists do and why does it matter?
Computer scientists design, analyze, and build computational systems that solve complex, real-world problems. It is not just about writing code; it is about expanding computational efficiency, developing advanced models like Artificial Intelligence (AI), and architecting stable digital infrastructure. This work matters because computation touches every modern industry. Whether it is optimizing automated logistics, protecting personal data, or training autonomous decision-making agents (like the reinforcement learning model in this course), computer scientists drive technological evolution and heavily influence how society functions.

#### How do I approach a problem as a computer scientist?
As a computer scientist, I approach problems through a lens of algorithmic thinking and iterative optimization. This starts with breaking down a complex problem into smaller, mathematically sound components (decomposition). In the context of this project, a complex pathfinding problem was reframed as a Markov Decision Process (MDP) mapped to a deep neural network. I then formulate a logical strategy, convert it into a programmatic baseline, test it extensively against data, analyze performance metrics (such as loss curves or win rates), and iteratively refine the code to maximize stability and minimize performance bottlenecks.

#### What are my ethical responsibilities to the end user and the organization?
My ethical responsibilities are divided between transparency to the end user and security compliance for the organization:
* **To the End User:** I am responsible for safety, predictability, and data privacy. Especially when dealing with machine learning and AI, I must remain transparent about how models are trained, actively evaluate training data for implicit biases, and protect the end user's personal data from exposure or leaks.
* **To the Organization:** I owe an obligation to deliver secure, legally compliant, and high-quality software that does not expose the enterprise to financial or reputational liability. This means adhering to secure coding standards, using open-source packages ethically within legal guidelines, and validating models to ensure they do not produce unpredicted or harmful systemic outcomes.
