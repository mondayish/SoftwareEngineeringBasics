#!/bin/bash

commit() {
  svn rm --force *
  cp -r $COMMITS/r$1/* .
  svn add --force *
  svn commit -m r$1 --username $USER
}

new_branch_from_trunk() {
	svn copy $REMOTE_URL/trunk $REMOTE_URL/branches/br$1 -m "Add br$1" --username $USER
}

new_branch() {
	svn copy $REMOTE_URL/branches/br$1 $REMOTE_URL/branches/br$2 -m "Add br$2" --username $USER
}

change_branch() {
	svn switch $REMOTE_URL/branches/br$1
}

change_branch_to_trunk() {
	svn switch $REMOTE_URL/trunk
}

merge() {
	svn merge --non-interactive $REMOTE_URL/branches/br$1
	svn resolved *
}

red_user() {
	USER=red
}

blue_user() {
	USER=blue
}


#init
rm -rf lab2_svn
mkdir lab2_svn
cd lab2_svn

#init remote
red_user
svnadmin create origin
REMOTE_URL="file://$(pwd -P)/origin"
COMMITS=~/misp/commits
svn mkdir -m "project structure" $REMOTE_URL/trunk $REMOTE_URL/branches --username $USER

#init local
svn checkout $REMOTE_URL/trunk working_copy
cd working_copy

#r0
# change to commit() ???? check it
cp -r $COMMITS/r0/* .
svn add --force *
svn commit -m "r0" --username $USER

#r1
commit 1

#r2
blue_user
new_branch_from_trunk 2
change_branch 2
commit 2

#r3
new_branch 2 1
change_branch 1
commit 3

#r4
red_user
change_branch_to_trunk
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
change_branch_to_trunk
commit 9

#r10
blue_user
change_branch 1
commit 10

#r11
red_user
change_branch_to_trunk
merge 1
commit 11

#r12
blue_user
change_branch 2
commit 12

#r13
red_user
change_branch_to_trunk
merge 2
commit 13

#r14
commit 14





