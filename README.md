# demo visualvm
kotlin で作ったものを visualvm でパフォーマンス計測してみる

## 内容
1. 適当なリストを生成
2. リストを`for`ループで回して各要素に処理して処理後のリストを作る

`map`で処理したものと比較

## memo
- 遅延評価の速さも測りたい
- sequence あたりの速さも測りたい
- 結果を書くときに端末のスペックも書いておきたい

## usage
こんな感じ`./gradlew bootRun --args='--target=list'`

`./gradlew bootRun`すると usage を出力するようになっている
