# The name of the driver class that is used in the Class.forName() method to load the driver.
#
# This is used by Jenny to get meta data like the table names.
#
# This property is required.
#
# Driver=com.inet.tds.TdsDriver
# Driver=com.mysql.jdbc.Driver

Driver=com.mysql.jdbc.Driver

# The URL that is passed into the DriverManager.getConnection() method to get a connection.
#
# This is used by Jenny to get meta data like the table names.
#
# This property is required.
#
# URL=jdbc:driver://hostname/databasename
# URL=jdbc:mysql://localhost/soup

URL=jdbc:mysql://gnode1.mib.man.ac.uk/prj_mbaxhgk4

# Some databases require a user name and password to get access.  
# If your database requires this, you must provide that information here.
# Otherwise, it's best to leave it out.
#
# UserName=databaseusername
# Password=databaseuserpassword
#
# UserName=webapp
# Password=frootloops
#
# UserName=bobjones
# Password=bluegoat
#
# UserName=megacorp
# Password=spoooooon

UserName=mbax9sl3
Password=7J8^ck$U2uHXC2JZ

# Where the generated files will be put.
#
# Everything in this directory will be deleted when Jenny starts. Then the generated facade class and all the
# generated table classes will be created here.
#
# Make sure you include the trailing slash.
#
# This property is required.
#
# Destination=/java/src/com/javaranch/db/soup/
# Destination=/work/src/com/megacorp/projectx/database/accountsdb/

Destination=/Users/Stefan/workspace/EpiWeb/src/epiweb/server/epidb/

# The package name to use at the top of all the generated files.
#
# This property is required.
#
# Package=com.javaranch.db.soup
# Package=com.megacorp.projectx.database.accountsdb

Package=epiweb.server.epidb

# The name of the generated facade class.
#
# This is the name of the class that will extend DBFacade and use your means of database access to override DBFacade.
# All of the generated table classes will use this facade for all database access.
#
# Any instance of a database server will have one or more databases in it. Typically, a large project would have 
# six to ten databases. I suggest that for each database, you have a different package and facade.
#
# Example:
#
#     Suppose you have three databases on a server:  "primary", "transactions" and "legacy".  You would want to run 
#     Jenny three times, with three different property files and put the tables of each database into three packages.
#     Something like com.megacorp.db.primary, com.megacorp.db.transactions and com.megacorp.db.legacy. The facades 
#     would be PrimaryFacade, TransactionsFacade and LegacyFacade.
#
# It's also possible that you have one database that you access within EJB's and outside of EJB's.  One way to handle
# this would be to override the facade for one way and to set the instance to the new way.  Everything within one VM
# would then use the new way, and everything that ran in another VM would use the default way.  Or, you could get
# your own connection and feed that in to each method.  Or (and this is my point) you could run Jenny twice.  Once 
# for stuff inside of EJB's and once for stuff outside of EJB's.
#
# Example:
#
#     Suppose you have a database called "moo".  Most of your database access is going to be done within the EJB
#     stuff, so you set up a package called com.farmcorp.ejb.db.moo and call your facade "MooFacade".  Then for 
#     the standalone utilities you write that work with the same data, you use the package com.farmcorp.tools.db.moo 
#     and call your facade "MooFacade".  Or maybe "ToolsFacade" in the com.farmcorp.tools.db package.
#
# This property is required.
#
# Facade=SoupFacade
# Facade=LegacyFacade
# Facade=PrimaryFacade

Facade=EpidbFacade

# Now you need to specify how your facade accesses the database.
#
# There are two general ways to get a database connection:
#
#       Load a driver class and use that to get a connection (usually for stuff outside of EJB).
#
#             For this, provide FacadeDriver, FacadeURL and optionally FacadeUserName and FacadePassword.
#
#       Use a JNDI call to get a datasource (usually for stuff inside of EJB).
#
#             For this, provide FacadeJNDI
#
# If you don't specify FacadeDriver, the following properties will be copied:
#
#                   Driver      would be copied to    FacadeDriver
#                   URL         would be copied to    FacadeURL
#                   UserName    would be copied to    FacadeUSerName
#                   Password    would be copied to    FacadePassword
#
#
# These properties are not required.
#
# FacadeDriver=com.databasecompany.TheirDriver
# FacadeURL=jdbc:driver://hostname/databasename
# FacadeUserName=databaseusername
# FacadePassword=databaseuserpassword
#
# FacadeDriver=com.mysql.jdbc.Driver
# FacadeURL=jdbc:mysql://localhost/soup
#
# FacadeDriver=com.inet.tds.TdsDriver
# FacadeURL=jdbc:inetdae7://localhost/webdata
# FacadeUserName=megacorp
# FacadePassword=spoooooon
#
# FacadeJNDI=java:comp/env/jdbc/DataSource


# Jenny will generate mocks for all of her generated classes to help you with your unit testing.  All you need 
# to do is to tell Jenny where you want the mock files to be put.  Most folks put their unit test code in a different
# directory and give it the same package name.  So above you may have specified "/java/src/com/javaranch/db/soup/"
# for the destination directory, and "com.javaranch.db.soup" for the package.  So all of your production code source
# is kept in /java/src.  If you keep your unit test code in /java/test, you would want to set your MockDestination
# to "/java/test/com/javaranch/db/soup/".
#
# This property is not required.  If you don't provide it, no mock code is generated.
#
# MockDestination=/Users/Stefan/workspace/EpiWeb/test/epiweb/epidb/

