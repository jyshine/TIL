#JDK버전관리 jenv

1.homebrew 업데이트
```
$ brew update
```

2.java 설치
```
$ brew install --cask adoptopenjdk11
```


3.java version 확인
```
$ java -version
```

4.jenv 설치
```
$ brew install jenv

## 사용중인 shell 확인
$ echo $SHELL

## 설정파일 추가
## bash일 경우
$ echo 'export PATH="$HOME/.jenv/bin:$PATH"' >> ~/.bash_profile
$ echo 'eval "$(jenv init -)"' >> ~/.bash_profile

## zsh일 경우
$ echo 'export PATH="$HOME/.jenv/bin:$PATH"' >> ~/.zshrc
$ echo 'eval "$(jenv init -)"' >> ~/.zshrc

## 변경 사항 저장
$ source ~/.zshrc

```

5.jenv 관리 항목 추가
```
## 설치된 jdk 버전들 확인

## Cask 'adoptopenjdk11' is unavailable: No Cask with this name exists.
## 이후로 동일한 명령어를 넣으면 이제는'adoptopenjdk11'이라는 이름을 가진 ## 파일을 Cask하지 못했다고 합니다. 아마도, Cask가 homebrew 라이브러리에 ## 저장된 파일을 복제해서 가져오는데 문제가 생긴 듯 합니다. 무언가를 참조할 때 ## 정확한 경로를 넣어야하는 것처럼, 단순히 설치 파일명만 기재해서는 JDK11을 
## 불러올 수 없나봅니다. 
## 이러저러한 시도 끝에 찾아낸 바는, brew 명령어에 
## /openjdk/adoptopenjdk11 을 추가해주는 것입니다.


$ brew install --cask adoptopenjdk/openjdk/adoptopenjdk11


$ ls Library/Java/JavaVirtualMachines

$ jenv add /Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home

$ jenv add /Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home

$ jenv global 1.8.0.292
$ jenv versions

## 11	버전 사용
$ jenv local openjdk64-11.0.11

## Project Settings > Project > Project SDK가 11로 설정되어있는지 확인

```

