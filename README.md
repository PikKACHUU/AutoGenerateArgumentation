# AutoGeneratePersuasivePresentation

## Design concept
`Persuasive technology` is a relatively recent research area which studies the impact that digital interventions can have on people's behaviour or beliefs. This project would use some persuasive technology research, combined with       argumentation strategies, to produce a system that could dynamically create a collection of information to present to an audience in the form of a slide presentation on a topic, in order to claim a point, or present an argument. The project, starting from an annotated collection of material (e.g. pictures, catch phrases, snippets of information), will produce an intelligent system able, on the basis of argumentation techniques, to automatically create a "narrative", a sequence of images and phrases, that can be presented in the form of a set of slides to a user. 

## Material Collection 
Use only [JSON](http://www.json.org "JSON") Document or utilize NoSQL([MongoDB](https://www.mongodb.com "MongoDB")), depending on the Data Size. If Data Size is in GB Unit , DB should be used because it is more scalable and convenient, otherwise use JSON document will be more light and with lower workload. 
No matter how , the materials should be stored in the JSON style shown below. (Temporal Proposal)
    
### Method one 
object includes all the information related to it / pictures ,parses will be object's attribute / easy for code,hard for logic

```
  {
  "ObjectName": String,
  "ObjectID" : int,
  "Pictures":[
  {"ImageID": int,
   "Strength": int,
   "URL": String
  }],
  "Phrases":[{
  "PhraseID": int,
  "Strength": int,
  "content": String
  }],
  "Snippets":[{
  "SinppetID": int,
  "Strength": int,
  "content": String
  }],
  (to be determined)
  }  
  ```
* Pictures array(Pictures[])
    * `ObjectName` is marked for the Name of the Object such as Tomoto.
    * `ObjectID` is used for querying it.(AS Math.random a number to select which object will be utilized.) 
    * `Pictures[]` is a array that stores images with attributes:
    * `ImageID` is used for querying it.
    * `Strength` is used to symbolize the strength of this material(range is [-3,3]), while `-3` denotes this material is    strong negative, `-2` denotes this material is negative, '-1' denotes the material is weak negative, "0" denotes it is neutral. As is same for the number [0,3].
    * `URL` is used to store the Hyperlink of this image.
* Same for Phrases[] and Snippets[].
  

  
  
  
    






