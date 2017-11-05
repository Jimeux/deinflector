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
