function solution(str) 
{
  let answer = 0;

  let [open, close, qm] = [0, 0, 0];
  let prev = null;
  for(const ch of str)
  {
    if(ch === '<')
    {
      if(prev === '>')
      {
        const min = Math.min(open, close);
        const diff = Math.min(Math.abs(open - close), qm);
        qm -= diff;
        answer = Math.max(answer, (min + diff + Math.floor(qm / 2))*2);
        [open, close, qm] = [0, 0, 0];
      }

      open++;
    }
    else if(ch === '>')
    {
      if(open + qm === 0)
        continue;

      close++;
      if(open + qm === close)
      {
        const min = Math.min(open, close);
        const diff = Math.min(Math.abs(open - close), qm);
        qm -= diff;
        answer = Math.max(answer, (min + diff + Math.floor(qm / 2))*2);

        [open, close, qm] = [0, 0, 0];
      }
    }
    else 
      qm++;

    prev = ch;
  }

  const min = Math.min(open, close);
  const diff = Math.min(Math.abs(open - close), qm);
  qm -= diff;
  answer = Math.max(answer, (min + diff + Math.floor(qm / 2))*2);

  return answer;
}

console.log(solution(">>???<>>"));