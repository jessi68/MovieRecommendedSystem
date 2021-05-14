/*@NonNullApi


import org.springframework.lang.NonNullApi;
*/

// 이렇게 하면 현재 domain 패키기에 있는 모든 클래스 member variable , member function 에
// @NonNull annotation 붙은 것과 같은 효과남
// NonNull 이 대부분이면 이거 적용하고 Nullable 가능한 애만 annotatation 붙음
// 근데 툴 지원 못받음( intellij)
// 이걸 제대로 쓰려면 intellij 가 더 똑똑해야 함 ㅋㅋㅋㅋ

package com.example.demo.domain;