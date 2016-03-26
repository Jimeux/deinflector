# Deinflector

Remove inflections from Japanese words. For example, given the 
inflected term 聞かれました, we can get the base form 聞く. 

Deinflected terms are returned with a constant representing the type 
of inflection the word contained. This can be used to help filter 
bogus results.

# Usage

```java
final List<Deinflection> deinflections = 
        Deinflector.deinflect("聞かれました");
        
//[聞かれる [2], 聞かる [1], 聞く [1], 聞かれます [1]]
```

# Limitations

1. ある, くれる, いらっしゃる (and other special -aru verbs) are 
not currently handled.
2. Some nonsensical deinflections occur, e.g. volitional -> potential.
3. Additional inflections such as -ちまう, -とく, etc. could be added.
4. More tests are needed. 

# License

```
Copyright 2016 James Kirk

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```