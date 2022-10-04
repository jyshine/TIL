# Linux alias for Git command

```bash
alias ll='ls -l'
alias
unalias ll
```

## 항상 별칭을 적용하려는 경우
bash가 실행될 때 bash의 환경 정보가 포함된 `.bashrc` 파일을 읽어 들인다. 이 환경 정보에는 별칭 정보도 함께 들어간다. 즉, `.bashrc` 파일에 별칭을 설정해두면 언제나 별칭이 적용된다. `.bashrc` 파일은 각 계정의 홈 디렉터리에 존재한다. 각 계정의 홈 디렉터리(`~`)에서 `ls -al` 명령어를 입력 후 최상단을 보면 찾아볼 수 있다.

`.bashrc` 파일에 직접 별칭을 입력해도 되지만, 기존 alias와 구분하기 위해 `.bash_aliases` 파일을 생성한다.

```bash
touch .bash_aliases

```

```bash
# ZSH Aliases
alias gche='git config --global user.email'
alias gcj='git config --global user.email june@gmail.com'
alias gcs='git config --global user.email june222@gmail.com'
alias gs='git status'
alias ll='ls -l'
alias cddd='cd ~/dev/inflearn/spring/source/advanced/spring-advanced/'

gac(){
git add .; git commit -m $1;
}
```

crontab 실행 로그 조회

별도의 파일로 만들기

```bash
/etc/rsylog.d
default.conf 수정

$ sudo vi /etc/rsyslog.d/50-default.conf

```

#git