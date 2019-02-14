Make sure all @OneToOne or @ManyToOne properties marked as LAZY fetch
@OneToOne(fetch=FetchType.LAZY)
	private Role role;
	
this will make sure that other table data did not fetch by default.

	create User Section
	@ManyTOMany
	@JoinTable(
	joinColumns=@JoinColumn(),inverseJoinColumns=@JoinColumn()
	)
	
	add
	@ManyToMany(mappedBy="courses")

TODO:  
Sorting [done]  
paging[done]  
search by email  
search by name  
search by rolename  

##URL  
localhost:8080/search  
localhost:8080/search?sort=name,desc  
localhost:8080/search?sort=name,asc&page=0&size=1  
PagedListHolder  
PageImpl  

https://www.baeldung.com/rest-api-query-search-language-more-operations  
http://localhost:8080/user/search?search=role:Admin,name~pras  
We have two sets of operations:  

##Simple – can be represented by one character  
Equality: represented by colon (:)  
Negation: represented by Exclamation mark (!)  
Greater than: represented by (>)  
Less than: represented by (<)  
Like: represented by tilde (~)  
##Complex – need more than one character to be represented  
Starts with: represented by (=prefix*)  
Ends with: represented by (=*suffix)  
Contains: represented by (=*substring*)    

#Oracle Connectivity  
* Add Oracle jar file   
	&lt;dependency&gt;   
        &lt;groupId&gt;com.oracle&lt;/groupId&gt;  
        &lt;artifactId&gt;ojdbc7&lt;/artifactId&gt;  
        &lt;version&gt;12.1.0&lt;/version&gt;  
    &lt;/dependency&gt;    
    
	spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl  
	spring.datasource.username =username  
	spring.datasource.password =pass  
	spring.datasource.driver-class-name=oracle.jdbc.OracleDriver  
