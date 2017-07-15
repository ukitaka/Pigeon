## Grammar

+ `digit-zero` →  0
+ `digit-non-zero` →  1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9
+ `digit` →  `digit-zero` | `digit-non-zero`
+ `digits` →  `digit`
+ `digits` →  `digit` `digit`
+ `integer` → `digits`

+ `addition` → `integer`  `+`  `integer`

