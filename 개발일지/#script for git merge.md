script for git merge


작업을 하거나 시작하기 전에 develop1~3 Git branch를 master 와 sync 맞추기 위해 merge 하는 경우가 많았습니다.
프로젝트가 많아지면서 형상관리하는 툴 이용해서 프로젝트별로 merge 하는게 번거로운 것 같아서 git merge 스크립트 생성했다.


1. gitmerge.sh 생성

```
PROJECT_FOLDER=$1
FROM_BRANCH=$2
TO_BRANCH=$3


#echo $PROJECT_FOLDER
#echo $FROM_BRANCH
#echo $TO_BRANCH

cd $PROJECT_FOLDER
git show-ref
git remote update
git fetch --all
git checkout $TOBRANCH
git merge --no-ff --no-edit $FROMBRANCH
LASTSTATUS=$?

echo "last status of git merge was $LASTSTATUS"

if [ $LASTSTATUS -ne 0 ]; then
    echo "The merge failed."
    exit 1  
fi

git push
git push --tags


```


2. 스트립트 실행

```
$ zsh ./gitmerge.sh 프로젝트_폴더명 FROM_브랜치 TO_브랜치 

$ zsh ./gitmerge.sh onesell-backend-api dev1-auto-merge-test develop1  

```


http://www.rndblog.com/bash-script-for-git-merge/

#git 