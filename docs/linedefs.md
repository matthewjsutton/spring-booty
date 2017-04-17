* This file can then be edited directly from GitHub
  * https://github.com/joeyslalom/spring-booty/blob/master/src/main/resources/linedefs.json
  * Once committed from the GitHub web UI, this will start another build in the pipeline
* File is a json document with only a list
  * Each item in the list contains a LineDef
  * LineDefs can easily be added / removed / modified
* We also added a new fields for identity, “subGuidId” and “gdsId”
  * These fields are a combined key, so each element in the LineDef list must have a unique pair of subGuidId + gdsId
  * The service which leverages this json document will also query elements by the unique pair of subGuidId + gdsId
* Removed the fields for airfare authorization, car rate, and hotel rate
  * These fields are constant for all LineDefs so do not need to be defined
* Authorizer Emails
  * There is one field, authorizerEmail which is required
  * There are three lists, authorizerEmails1x, authorizerEmails2x, authorizerEmails3x, which can have any number of elements (including being empty)
* All fields aside from Authorizer Email lists are free-form strings (no dates, numbers, etc.)
* All fields are required and cannot be empty (aside from AuthorizeEmail lists)
* Source fields
  * Every field (aside from the identity fields subGuidId and gdsId) has a “Source” counterpart (e.g., travelerType, travelerTypeSource)
  * This field is not a definition but links the corresponding field to its source
  * This is also free form field, we won’t ensure sources are valid (writing “Towerbase” rather than “Powerbase” won’t be an error)
