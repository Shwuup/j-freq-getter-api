# j-vocab-freq-getter-api

API for j-vocab-freq-getter.


## Usage

Download binary from [releases](https://github.com/Shwuup/j-freq-getter-api/releases). 

Then run from your terminal:
```
java -jar /path/to/your/directory/j-vocab-freq-getter-assembly-{VERSION}.jar 
```
##Examples
###Request
```$xslt
curl -i -X POST localhost:8001/upload \
-H "Content-Type: text/xml" \
--data-binary "@testData.txt"
```
###Response
```$xslt
{
    "totalFreq": 165,
    "jlptTotal": [
        {
            "word": "する",
            "jlptLevel": "5",
            "freq": 15
        },
        {
            "word": "日本",
            "jlptLevel": "3",
            "freq": 7
        },
        {
            "word": "行う",
            "jlptLevel": "4",
            "freq": 6
        },
        {
            "word": "側",
            "jlptLevel": "3",
            "freq": 6
        },
        {
            "word": "防衛",
            "jlptLevel": "1",
            "freq": 6
        },
        {
            "word": "協議",
            "jlptLevel": "1",
            "freq": 5
        },
        {
            "word": "問題",
            "jlptLevel": "5",
            "freq": 4
        },
        {
            "word": "日",
            "jlptLevel": "4",
            "freq": 4
        },
        {
            "word": "こと",
            "jlptLevel": "4",
            "freq": 4
        },
        {
            "word": "出席",
            "jlptLevel": "4",
            "freq": 3
        }
    ],
    "jlpt1List": [
        {
            "word": "防衛",
            "jlptLevel": "1",
            "freq": 6
        },
        {
            "word": "協議",
            "jlptLevel": "1",
            "freq": 5
        },
        {
            "word": "的",
            "jlptLevel": "1",
            "freq": 2
        },
        {
            "word": "幹部",
            "jlptLevel": "1",
            "freq": 2
        },
        {
            "word": "機",
            "jlptLevel": "1",
            "freq": 2
        },
        {
            "word": "証拠",
            "jlptLevel": "1",
            "freq": 2
        },
        {
            "word": "対応",
            "jlptLevel": "1",
            "freq": 2
        },
        {
            "word": "審議",
            "jlptLevel": "1",
            "freq": 2
        },
        {
            "word": "客観",
            "jlptLevel": "1",
            "freq": 2
        },
        {
            "word": "公開",
            "jlptLevel": "1",
            "freq": 1
        }
    ],
    "jlpt2List": [
        {
            "word": "電波",
            "jlptLevel": "2",
            "freq": 2
        },
        {
            "word": "本部",
            "jlptLevel": "2",
            "freq": 2
        },
        {
            "word": "含める",
            "jlptLevel": "2",
            "freq": 2
        },
        {
            "word": "重ねる",
            "jlptLevel": "2",
            "freq": 1
        },
        {
            "word": "防止",
            "jlptLevel": "2",
            "freq": 1
        },
        {
            "word": "合同",
            "jlptLevel": "2",
            "freq": 1
        },
        {
            "word": "改めて",
            "jlptLevel": "2",
            "freq": 1
        },
        {
            "word": "鐘",
            "jlptLevel": "2",
            "freq": 1
        },
        {
            "word": "下旬",
            "jlptLevel": "2",
            "freq": 1
        }
    ],
    "jlpt3List": [
        {
            "word": "日本",
            "jlptLevel": "3",
            "freq": 7
        },
        {
            "word": "側",
            "jlptLevel": "3",
            "freq": 6
        },
        {
            "word": "誤解",
            "jlptLevel": "3",
            "freq": 2
        },
        {
            "word": "級",
            "jlptLevel": "3",
            "freq": 2
        },
        {
            "word": "軍",
            "jlptLevel": "3",
            "freq": 2
        },
        {
            "word": "示す",
            "jlptLevel": "3",
            "freq": 2
        },
        {
            "word": "発表",
            "jlptLevel": "3",
            "freq": 2
        },
        {
            "word": "記録",
            "jlptLevel": "3",
            "freq": 2
        },
        {
            "word": "交換",
            "jlptLevel": "3",
            "freq": 2
        },
        {
            "word": "元",
            "jlptLevel": "3",
            "freq": 1
        }
    ],
    "jlpt4List": [
        {
            "word": "行う",
            "jlptLevel": "4",
            "freq": 6
        },
        {
            "word": "日",
            "jlptLevel": "4",
            "freq": 4
        },
        {
            "word": "こと",
            "jlptLevel": "4",
            "freq": 4
        },
        {
            "word": "出席",
            "jlptLevel": "4",
            "freq": 3
        },
        {
            "word": "関係",
            "jlptLevel": "4",
            "freq": 2
        },
        {
            "word": "続く",
            "jlptLevel": "4",
            "freq": 2
        },
        {
            "word": "用",
            "jlptLevel": "4",
            "freq": 2
        },
        {
            "word": "意見",
            "jlptLevel": "4",
            "freq": 2
        },
        {
            "word": "石",
            "jlptLevel": "4",
            "freq": 1
        },
        {
            "word": "形",
            "jlptLevel": "4",
            "freq": 1
        }
    ],
    "jlpt5List": [
        {
            "word": "する",
            "jlptLevel": "5",
            "freq": 15
        },
        {
            "word": "問題",
            "jlptLevel": "5",
            "freq": 4
        },
        {
            "word": "午後",
            "jlptLevel": "5",
            "freq": 2
        },
        {
            "word": "なる",
            "jlptLevel": "5",
            "freq": 2
        },
        {
            "word": "大使館",
            "jlptLevel": "5",
            "freq": 2
        },
        {
            "word": "中",
            "jlptLevel": "5",
            "freq": 2
        },
        {
            "word": "など",
            "jlptLevel": "5",
            "freq": 1
        },
        {
            "word": "テレビ",
            "jlptLevel": "5",
            "freq": 1
        },
        {
            "word": "午前",
            "jlptLevel": "5",
            "freq": 1
        },
        {
            "word": "上",
            "jlptLevel": "5",
            "freq": 1
        }
    ]
}
```

