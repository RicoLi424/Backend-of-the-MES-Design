# Backend-of-the-MES-Design
MES is the execution layer between the planning layer and the field automation system, and is mainly responsible for workshop production management and scheduling execution.  
* **_Workshop Management_**  
It mainly includes the functions of creating, modifying, deleting and querying factory workshops, production lines and workstations.
* **_Warehouse Management_**  
Is used to realize the management of shelves, materials and equipment in the warehouse area. The system is mainly composed of the following modules: storage area shelf management, material equipment management, and storage management.  
* **_Production Planning Management_**  
Is used to realize the distribution of customer orders to production orders.  
  customer order management: realize the CRUD of customer orders.
  production planning order management: According to the production requirements of different products in customer orders, customer orders are allocated to various workshops and production lines, and each production line corresponds to a production planning order. This module realizes the process of allocating orders, as well as the functions of modifying, querying and deleting the status of production planning orders.  
