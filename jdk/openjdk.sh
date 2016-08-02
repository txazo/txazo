export LANG=C
export ALT_BOOTDIR=/Library/Java/JavaVirtualMachines/current.jdk/Contents/Home
export ALLOW_DOWNLOADS=true
export USE_PRECOMPILED_HEADER=true
export SKIP_DEBUG_BUILD=false
export SKIP_FASTDEBUG_BUILD=true
export DEBUG_NAME=debug
unset CLASSPATH
unset JAVA_HOME

make sanity

make clean
make

http://pan.baidu.com/s/1kUIK5YR