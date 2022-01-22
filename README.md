# code-challange
Standalone Web App with Java BE &amp; Angular UI

# JBoss/Wildfly 26.0 Final
admin console: http://localhost:9990/console/index.html
<br>
We will add environment variables here for additional security.
<br>
user: ***
password: ***

# Maven
version: apache-maven-3.8.4

### Prerequisites 
Configure working directory of the application:
* Install and download node.js 12+
* Install and download wildfly 26.0
* Install and download angular-cli 10+

## Start - Stop
**To run angular only:**
$ cd webapp/front-end
$ ng serve

validate angular app at: http://localhost:4200/

**In order to deploy to wildfly**
- stop ng serve to not get confused
- then at webapp dir level:
  $ mvn clean package
  $ deploy the war file to wildfly

load the angular app at: http://localhost:8080/webapp
