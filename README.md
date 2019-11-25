<h1 class="code-line" data-line-start=0 data-line-end=1 ><a id="Task_Manager_System_0"></a>Task Manager System</h1>
<h2 class="code-line" data-line-start=2 data-line-end=3 ><a id="Objective_2"></a>Objective:</h2>
<h4 class="code-line" data-line-start=4 data-line-end=5 ><a id="This_application_was_developed_in_order_to_be_able_to_manage_Tasks_being_able_to_register_edit_disable_and_list_various_tasks_4"></a>This application was developed in order to be able to manage Tasks, being able to register, edit, disable and list various tasks.</h4>
<h2 class="code-line" data-line-start=6 data-line-end=7 ><a id="Main_Technologies_6"></a>Main Technologies:</h2>
<ul>
<li class="has-line-data" data-line-start="8" data-line-end="9">JAVA SPRING BOOT</li>
<li class="has-line-data" data-line-start="9" data-line-end="10">SPRING DATA JPQ</li>
<li class="has-line-data" data-line-start="10" data-line-end="11">APACHE TOMCAT</li>
<li class="has-line-data" data-line-start="11" data-line-end="12">RESTFUL API</li>
<li class="has-line-data" data-line-start="12" data-line-end="13">MYSQL</li>
<li class="has-line-data" data-line-start="13" data-line-end="14">SWAGGER Documentation</li>
<li class="has-line-data" data-line-start="14" data-line-end="16">PRINCIPLES S.O.L.I.D</li>
</ul>
<h2 class="code-line" data-line-start=16 data-line-end=17 ><a id="Minimum_prerequisites_16"></a>Minimum prerequisites:</h2>
<ul>
<li class="has-line-data" data-line-start="17" data-line-end="18">Java 8</li>
<li class="has-line-data" data-line-start="18" data-line-end="19">Mysql</li>
<li class="has-line-data" data-line-start="19" data-line-end="20">Creation of named database: ‘task-management’</li>
<li class="has-line-data" data-line-start="20" data-line-end="23">Creation of user in mysql<br>
username=teste<br>
password=teste</li>
</ul>
<h2 class="code-line" data-line-start=25 data-line-end=26 ><a id="Running_Application_25"></a>Running Application:</h2>
<ul>
<li class="has-line-data" data-line-start="27" data-line-end="28">Clone this project</li>
<li class="has-line-data" data-line-start="28" data-line-end="29">Run the project through eclipse or generate JAR through Maven</li>
<li class="has-line-data" data-line-start="29" data-line-end="30">If generating by Maven just use the command below:</li>
</ul>
<pre><code class="has-line-data" data-line-start="31" data-line-end="34" class="language-sh">mvn package
java -jar nameProjetc.jar
</code></pre>
<h2 class="code-line" data-line-start=35 data-line-end=36 ><a id="Testing_Application_35"></a>Testing Application:</h2>
<p class="has-line-data" data-line-start="36" data-line-end="37"><a href="http://localhost:8080/tasks">http://localhost:8080/tasks</a></p>
<h2 class="code-line" data-line-start=38 data-line-end=39 ><a id="SWAGGER_Documentation_38"></a>SWAGGER Documentation:</h2>
<h2 class="code-line" data-line-start=41 data-line-end=42 ><a id="Project_Dependencies_41"></a>Project Dependencies:</h2>
<pre><code class="has-line-data" data-line-start="43" data-line-end="102" class="language-sh">&lt;dependencies&gt;
    &lt;dependency&gt;
        &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
        &lt;artifactId&gt;spring-boot-starter-data-jpa&lt;/artifactId&gt;
    &lt;/dependency&gt;
    &lt;dependency&gt;
        &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
        &lt;artifactId&gt;spring-boot-starter-data-rest&lt;/artifactId&gt;
    &lt;/dependency&gt;
    &lt;dependency&gt;
        &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
        &lt;artifactId&gt;spring-boot-starter-web&lt;/artifactId&gt;
    &lt;/dependency&gt;
    &lt;dependency&gt;
        &lt;groupId&gt;io.springfox&lt;/groupId&gt;
        &lt;artifactId&gt;springfox-swagger2&lt;/artifactId&gt;
        &lt;version&gt;<span class="hljs-number">2.7</span>.<span class="hljs-number">0</span>&lt;/version&gt;
    &lt;/dependency&gt;
    &lt;dependency&gt;
        &lt;groupId&gt;io.springfox&lt;/groupId&gt;
        &lt;artifactId&gt;springfox-swagger-ui&lt;/artifactId&gt;
        &lt;version&gt;<span class="hljs-number">2.7</span>.<span class="hljs-number">0</span>&lt;/version&gt;
    &lt;/dependency&gt;
    &lt;dependency&gt;
        &lt;groupId&gt;org.springframework.plugin&lt;/groupId&gt;
        &lt;artifactId&gt;spring-plugin-core&lt;/artifactId&gt;
        &lt;version&gt;<span class="hljs-number">1.2</span>.<span class="hljs-number">0</span>.RELEASE&lt;/version&gt;
    &lt;/dependency&gt;
    &lt;dependency&gt;
        &lt;groupId&gt;org.springframework.security.oauth&lt;/groupId&gt;
        &lt;artifactId&gt;spring-security-oauth2&lt;/artifactId&gt;
        &lt;version&gt;<span class="hljs-number">2.3</span>.<span class="hljs-number">4</span>.RELEASE&lt;/version&gt;
    &lt;/dependency&gt;

    &lt;dependency&gt;
        &lt;groupId&gt;org.modelmapper&lt;/groupId&gt;
        &lt;artifactId&gt;modelmapper&lt;/artifactId&gt;
        &lt;version&gt;<span class="hljs-number">2.3</span>.<span class="hljs-number">0</span>&lt;/version&gt;
    &lt;/dependency&gt;

    &lt;dependency&gt;
        &lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;
        &lt;artifactId&gt;spring-boot-devtools&lt;/artifactId&gt;
        &lt;scope&gt;runtime&lt;/scope&gt;
        &lt;optional&gt;<span class="hljs-literal">true</span>&lt;/optional&gt;
    &lt;/dependency&gt;
    &lt;dependency&gt;
        &lt;groupId&gt;com.h2database&lt;/groupId&gt;
        &lt;artifactId&gt;h2&lt;/artifactId&gt;
        &lt;scope&gt;runtime&lt;/scope&gt;
    &lt;/dependency&gt;
    &lt;dependency&gt;
        &lt;groupId&gt;mysql&lt;/groupId&gt;
        &lt;artifactId&gt;mysql-connector-java&lt;/artifactId&gt;
        &lt;scope&gt;runtime&lt;/scope&gt;
    &lt;/dependency&gt;

&lt;/dependencies&gt;
</code></pre>
<h2 class="code-line" data-line-start=103 data-line-end=104 ><a id="Note_103"></a>Note:</h2>
<p class="has-line-data" data-line-start="104" data-line-end="105">This application is just the backend, if you want frondend go to &lt;here&gt;</p>
<h2 class="code-line" data-line-start=106 data-line-end=107 ><a id="Version_106"></a>Version:</h2>
<p class="has-line-data" data-line-start="107" data-line-end="108">1.0.0</p>
<h2 class="code-line" data-line-start=108 data-line-end=109 ><a id="Author_108"></a>Author:</h2>
<p class="has-line-data" data-line-start="109" data-line-end="111">Thiago Salvador<br>
link Mais</p>
<h2 class="code-line" data-line-start=112 data-line-end=113 ><a id="License_112"></a>License:</h2>
<p class="has-line-data" data-line-start="113" data-line-end="114">The content of this project itself is licensed under the MIT license and intellectual property of the author.</p>