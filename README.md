# Backend-of-the-MES-Design
MES is the execution layer between the planning layer and the field automation system, and is mainly responsible for workshop production management and scheduling execution.  
* **_Workshop Management_**  
It mainly includes the functions of creating, modifying, deleting and querying factory workshops, production lines and workstations.
* **_Warehouse Management_**  
Is used to realize the management of shelves, materials and equipment in the warehouse area. The system is mainly composed of the following modules: storage area shelf management, material equipment management, and storage management.  
* **_Production Planning Management_**  
Is used to realize the distribution of customer orders to production orders.  
    * **customer order management**: realize the CRUD of customer orders.
    * **production planning order management**: According to the production requirements of different products in customer orders, customer orders are allocated to various workshops and production lines, and each production line corresponds to a production planning order. This module realizes the process of allocating orders, as well as the functions of modifying, querying and deleting the status of production planning orders.  
* **_Production Process Management_**  
It realizes the maintenance of the bill of materials, routing, and procedures involved in production. The main functions include bill of materials management, routing management, and procedure management.
* **_Product Quality Management_**  
It is used to realize the quality control of semi-finished products or finished products produced by workshop production lines in different processes. Quality inspectors randomly or regularly inspect semi-finished products or finished products produced by different production lines and processes, and enter the inspection results into the system.
* **_Basic System Management_**  
It realizes the management of users, roles, departments and permissions.
* **_Template Management_**  
It realize the management of attribute templates of entities in the system, such as materials, equipment, and processes. Different material attributes have different names and quantities. In order to adapt to various materials, equipment, etc., the system can dynamically adapt according to the actual attributes, and the system can accommodate different entities by establishing templates.
* **_Data Analysis Report_**  
It realizes the display of production plan progress, production plan preview, material inventory, and bad statistical information. 
   * **Production planning progress module:** Display the actual and planned completion quantities of products in different customer orders in the form of a bar chart.
   * **Material Inventory:** Display the current material inventory in the form of a table.
   * **Defective statistics:** Display the statistics of defective products from the beginning of the generation of planned orders to the current moment in the form of a graph.
