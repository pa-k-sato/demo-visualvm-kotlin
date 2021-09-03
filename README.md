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

## TODO
- [ ] gradle task として実行できる
    - https://stackoverflow.com/a/33429107
    - https://stackoverflow.com/a/36925752

## やっていること
引数に応じて下記の処理をする

### --target=list
1. 9,999,999 件の`List`を作る
2. 作った`List`をループして少し加工した新しい'List`を作る

### --target=sequence
1. 9,999,999 件の`List`を作る
2. 作った`List`を'Sequence`に変換する
3. 作った`Sequence`をループして少し加工した新しい'Sequence`を作る
4. 新しい`Sequence`を`List`に変換する
