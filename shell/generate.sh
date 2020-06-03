#!/bin/bash

# generate README.md
# format: leetcode xxx(problem number) github-link

files=$(ls ../src/leetcode/first)
prefix='https://github.com/17hao/algorithm/blob/master/src/leetcode/first/'

for i in $files; do
    num=$(echo $i | cut -f 2 -d _)
    echo "leetcode [$num](${prefix}$i)" >> ../README.md
done;