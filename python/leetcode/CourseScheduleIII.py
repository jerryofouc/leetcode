import Queue as Q
class Solution(object):
    def scheduleCourse(self, courses):
        """
        :type courses: List[List[int]]
        :rtype: int
        """
        courses.sort(key=lambda x : x[1])

        q = Q.PriorityQueue()
        q.put(-courses[0][0])
        count = 1
        time = courses[0][0]
        for i in  xrange(1,len(courses)):
            if time+courses[i][0]<=courses[i][1]:
                time = time+courses[i][0]
                q.put(-courses[i][0])
                count += 1
            else:
                max_value = -q.get()
                if max_value > courses[i][0]:
                    time = time +  courses[i][0]-max_value
                    q.put(-courses[i][0])
                else:
                    q.put(-max_value)

        return count






if __name__ == '__main__':
    s = Solution()
    course = [[7,17],[3,12],[10,20],[9,10],[5,20],[10,19],[4,18]]
    print s.scheduleCourse(courses=course)