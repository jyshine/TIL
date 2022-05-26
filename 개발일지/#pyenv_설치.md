#pyenv_설치


```
$ brew install pyenv pyenv-virtualenv

# 환경설정
$ echo 'export PATH="$HOME/.pyenv/bin:$PATH"' >> ~/.zshrc

$ echo 'eval "$(pyenv init -)"' >> ~/.zshrc

$ echo 'eval "$(pyenv virtualenv-init -)"' >> ~/.zshrc

# 저장
$ source ~/.zshrc

# python 설치
$ pyenv install 3.7.9 
$ pyenv install 3.10.4
$ pyenv versions

$ pyenv global 3.7.9
$ pyenv local 3.10.4


```
