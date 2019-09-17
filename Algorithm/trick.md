### 1、位运算

num & (num - 1) :   num最右侧1变为0

hashcode & (num - 1) :   hashmap中求模，num必须为2的整数倍

hashcode & 0x7FFFFFFF:   负数转换为正数

num & (-num):  最右侧1的位置