* This file can then be edited directly from GitHub
  * https://github.com/joeyslalom/spring-booty/blob/master/src/main/resources/linedefs.json
  * Once committed from the GitHub web UI, this will start another build in the pipeline
* File is a json document with only a list
  * Each item in the list contains a LineDef
  * LineDefs can easily be added / removed / modified
* We also added a new fields for identity, "topGuidId", “subGuidId”, and “gdsId”
  * These fields are a combined key, so each element in the LineDef list must have a unique combination of topGuidId + subGuidId + gdsId
  * The service which leverages this json document will also query elements by the same unique combination
* Removed the fields for airfare authorization, car rate, and hotel rate
  * These fields are constant for all LineDefs so do not need to be defined
* Authorizer Emails
  * There is one field, authorizerEmail which is required
  * There are three lists, authorizerEmails1x, authorizerEmails2x, authorizerEmails3x, which can have any number of elements (including being empty)
* All fields aside from Authorizer Email lists are free-form strings (no dates, numbers, etc.)
* sourceId fields
  * Fields values may come from separate sources; therefore each source has its own element
  * Each source can be used only once, two field elements cannot have the same source