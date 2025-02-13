<h1>Race Condition</h1>
<p>The code has one api for storing data into database api - localhost:8080/database/operation</p>
<p>Note:- This api adds only one item to database run it multiple time for adding multiple records into database</p>
<p>Now we have one another api which shift all data to archival table api - localhost:8080/database/operation/archival</p>
<h2>Error: -</h2>
<h4>org.springframework.orm.ObjectOptimisticLockingFailureException: Row was updated or deleted by another transaction (or unsaved-value mapping was incorrect): [com.example.demo.entity.DemoEntityArchival#1283]</h4>
