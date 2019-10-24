# AutoGeneratePersuasivePresentation
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2FPikKACHUU%2FAutoGenerateArgumentation.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2FPikKACHUU%2FAutoGenerateArgumentation?ref=badge_shield)
[![](https://img.shields.io/github/followers/PikKACHUU.svg?style=social&label=Follow%20Me)](https://github.com/PikKACHUU)

## Design concept

`Persuasive technology` is a relatively recent research area which studies the impact that digital interventions can have  on people's behaviour or beliefs.<br><br>
This project would use some persuasive technology research, combined with argumentation strategies, to produce a system that could dynamically create a collection of information to present to an audience in the form of a slide presentation on a topic, in order to claim a point, or present an argument. <br><br>
The project, starting from an annotated collection of  material (e.g. pictures, catch phrases, snippets of information), will produce an intelligent system able, on the basis of argumentation techniques, to automatically create a "narrative", a sequence of images and phrases, that can be  presented in the form of a set of slides to a user. 

## Material Collection

Use only [JSON](http://www.json.org "JSON") Document or utilize NoSQL([MongoDB](https://www.mongodb.com "MongoDB")), depending on the Data Size. <br><br>
If Data Size is in GB Unit , DB should be used because it is more scalable and convenient, otherwise use JSON document will be more light and with lower workload. <br><br>
No matter how , the materials should be stored in the JSON style shown below. (Temporal Proposal)

### Method one

Object includes all the information related to it / pictures ,parses will be object's attribute / easy for code,hard for logic

```
  {
  "ObjectName": String,
  "ObjectID" : int,
  "Pictures":[
  {"ImageID": int,
   "Strength": int,
   "PointTo": String,
   "URL": String
  }],
  "Phrases":[{
  "PhraseID": int,
  "Strength": int,
  "Content": String,
  "Type": String,
  "PointTo": String
  }],
  "Snippets":[{
  "SinppetID": int,
  "Strength": int,
  "Content": String,
  "Type": String,
  "PointTo": String
  }]
  }  
  ```

* general object
  * `ObjectName` is marked for the Name of the Object such as Tomato.
  * `ObjectID` is used to query it.(AS Math.random a number to select which object will be utilized.) 
* Pictures
  * `Pictures[]` is a array that stores images with attributes:
    * `ImageID` is used to query it.
    * `Strength` is used to symbolize the strength of this material(range is [-3,3]), while `-3` denotes this material is    strong negative, `-2` denotes this material is negative, `-1` denotes the material is weak negative, `0` denotes it is neutral. As is same for the number [0,3].
    * `PointTo` is used to denote which argument this image is pointed to, such as Price, Benefits, etc.
    * `URL` is used to store the Hyperlink of this image.
* Phrases
  * `Phrases[]` is a array that stores phrase with attributes:
    * `PhraseID` is used to query it.
    * `Strength` is used to symbolize the strength of this material(range is [-3,3]), while `-3` denotes this material is strong negative, `-2` denotes this material is negative, `-1` denotes the material is weak negative, `0` denotes it is neutral. As is same for the number [0,3]. 
    * `Content` is used to store the text of this phrase.
    * `Type` is used to denote the type of this phrase, such as MP(Main Point),P(Point),Sum(Summary).
    * `PointTo` is used to denote which argument this phrase is pointed to, such as Price, Benefits, etc. Especially for Point Type.
* Snippets
  * `Snippets[]` is a array that stores snippets with attributes:
    * `SnippetID` is used to query it.
    * `Strength` is used to symbolize the strength of this material(range is [-3,3]), while `-3` denotes this material is strong negative, `-2` denotes this material is negative, `-1` denotes the material is weak negative, `0` denotes it is neutral. As is same for the number [0,3]. 
    * `Content` is used to store the text of this snippet.
    * `Type` is used to denote the type of this snippet, such as Reason(RS), Example(EX),etc.
    * `PointTo` is used to denote which argument this snippet is pointed to, such as Price, Benefits, etc.
<br>

### Method two

Each material will be a Object. They will be saved in three document, Pictures.json , Phrases.json, Snippets.json <br> 
// Hard for code, easy for logic.

#### Phrase and Snippet

```
{
"Objects":[
{
 "ID": int,
 "Strength": int,
 "LinkTo": String,
 "Type": String,
 "PointTo": String,
 "Content": String
 }
]
}
```

* Objects
  * `Objects[]` has several attributes:
    * `ID`  stores the ID of this object
    * `Strength` denotes the strength of this material,range is [-3,3] (same as above)
    * `LinkTo` denotes the thing which this object is linked to ,such as tomoto,potato,etc.
    * `Type` denotes the type of this object such as MP,P,Sum,EX,RS.
    * `PointTo` is used to denote which argument this object is pointed to, such as Price, Benefits, etc.
    * `Content` is used to store the text of this object.

#### Picture

```
{
"Pictures":[
{
 "ID": int,
 "Strength": int,
 "LinkTo": String,
 "PointTo": String,
 "URL": String
 }
]
}
```

* Pictures
  * `Pictures[]` is a array that stores images with attributes:
    * `ID` is used for querying it.
    * `Strength` is used to symbolize the strength of this material(range is [-3,3]), while `-3` denotes this material is strong negative, `-2` denotes this material is negative, `-1` denotes the material is weak negative, `0` denotes it is neutral. As is same for the number [0,3].
    * `LinkTo` denotes the thing which this image is linked to ,such as tomoto,potato,etc.
    * `PointTo` is used to denote which argument this image is pointed to, such as Price, Benefits, etc.
    * `URL` is used to store the Hyperlink of this image.

## Code Logic

IDEA: Function to generate a List(LinkedList or ArrayList) that stores the material in order. <br>
      Then use this list to generate HTML or Slide. <br><br>

 Several templates could be writen in HTML,  and use `switch` key word to decide on which template it will utilize. <br>
(In details, Use `Math.random` to generate number from 1 to 3, if number is 1,then go to `case 1:` which is a template)<br>

### Template

The topic will be selected with Objects' ID (use random number) and `strengh`. <br>
For example in method one, i can get `Object[].size` and use the `size` to random select a object, this presentation will be focused on this selected object. Now, the name of this Object is obtained. Randomly select a template and quried required material according to the template.<br>
As is shown below:

* `p` denotes positive.
* `n` denotes negative.
* `PIC` denotes picture.
* `MP` denotes Main Point.
* `p` denotes point.
* `RS` denotes Reason.
* `EX` denotes Example.
* `Sum` denotes Summary.
<br>
For example, `pMP` denotes positive Main Point , etc.

#### pMP - PIC - pP - pRS - pEX - pP - pRS - pEX - Sum

#### nMP - PIC - nP - nRs - nEX - nP - nRS - nEX - Sum 

## Class Design

Picture



## License
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2FPikKACHUU%2FAutoGenerateArgumentation.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2FPikKACHUU%2FAutoGenerateArgumentation?ref=badge_large)
