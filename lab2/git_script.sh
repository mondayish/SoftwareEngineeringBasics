#!/bin/bash

commit() {
	ls | grep -v .git | xargs rm -rf
	cp ../commits/r$1/* .
	git add .
	git commit --allow-empty -m r$1
}

new_branch() {
	git checkout -b br$1
}

change_branch() {
	git checkout br$1
}

merge() {
	git merge br$1 --no-commit
}

red_user() {
	git config --local user.name red
	git config --local user.email red@gmail.com
}

blue_user() {
	git config --local user.name blue
	git config --local user.email blue@gmail.com
}


#init
rm -rf lab2_git
mkdir lab2_git
cd lab2_git
git init

#r0
red_user
new_branch 0
commit 0

#r1
commit 1

#r2
blue_user
new_branch 2
commit 2

#r3
new_branch 1
commit 3

#r4
red_user
change_branch 0
commit 4

#r5
commit 5

#r6
commit 6

#r7
blue_user
change_branch 2
commit 7

#r8
change_branch 1
commit 8

#r9
red_user
change_branch 0
commit 9

#r10
blue_user
change_branch 1
commit 10

#r11
red_user
change_branch 0
merge 1
commit 11

#r12
blue_user
change_branch 2
commit 12

#r13
red_user
change_branch 0
merge 2
commit 13

#r14
commit 14


